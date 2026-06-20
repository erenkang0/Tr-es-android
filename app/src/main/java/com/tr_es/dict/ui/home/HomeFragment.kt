package com.tr_es.dict.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tr_es.dict.NavGraphDirections
import com.tr_es.dict.R
import com.tr_es.dict.data.local.entity.WordEntity
import com.tr_es.dict.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var recentAdapter: RecentSearchAdapter

    private val gson = Gson()

    private data class Ex(val es: String = "", val tr: String = "")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recentAdapter = RecentSearchAdapter { word -> openWord(word.id) }
        binding.rvRecent.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.rvRecent.adapter = recentAdapter

        binding.searchBar.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_search)
        }
        binding.cardCta.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_flashcards)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.wordOfDay.collect { word -> bindWordOfDay(word) }
                }
                launch {
                    viewModel.recent.collect { list ->
                        recentAdapter.submitList(list)
                        binding.tvRecentEmpty.isVisible = list.isEmpty()
                        binding.rvRecent.isVisible = list.isNotEmpty()
                    }
                }
                launch {
                    viewModel.flashcardCount.collect { count ->
                        binding.tvCtaSub.text =
                            getString(R.string.cta_flashcards_subtitle, count)
                    }
                }
            }
        }
    }

    private fun bindWordOfDay(word: WordEntity?) {
        if (word == null) {
            binding.cardWod.setOnClickListener(null)
            binding.btnWodAudio.setOnClickListener(null)
            return
        }

        binding.tvWodWord.text = word.esWord

        val pronunciation = word.pronunciation
        binding.tvWodPron.text = pronunciation
        binding.tvWodPron.isVisible = !pronunciation.isNullOrBlank()

        binding.tvWodPos.text = word.partOfSpeech
        binding.tvWodPos.isVisible = word.partOfSpeech.isNotBlank()

        binding.tvWodMeaning.text = word.trMeaning

        val firstExample = parseFirstExample(word.examples)
        if (firstExample != null && firstExample.es.isNotBlank()) {
            binding.tvWodExample.text = firstExample.es
            binding.tvWodExample.isVisible = true
        } else {
            binding.tvWodExample.isVisible = false
        }

        binding.cardWod.setOnClickListener { openWord(word.id) }
        binding.btnWodAudio.setOnClickListener { openWord(word.id) }
    }

    private fun parseFirstExample(json: String?): Ex? {
        if (json.isNullOrBlank()) return null
        return try {
            val type = object : TypeToken<List<Ex>>() {}.type
            val list: List<Ex>? = gson.fromJson(json, type)
            list?.firstOrNull()
        } catch (e: Exception) {
            null
        }
    }

    private fun openWord(wordId: Long) {
        findNavController().navigate(NavGraphDirections.actionGlobalWordDetail(wordId))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
