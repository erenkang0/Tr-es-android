package com.tr_es.dict.ui.wordofday

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
import com.tr_es.dict.databinding.FragmentWordOfDayBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class WordOfDayFragment : Fragment() {

    private var _binding: FragmentWordOfDayBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WordOfDayViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordOfDayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dateStr = SimpleDateFormat("d MMMM yyyy", Locale("tr")).format(Date())
        binding.tvDate.text = dateStr

        binding.btnDetails.setOnClickListener {
            viewModel.word.value?.let { word ->
                val action = WordOfDayFragmentDirections.actionWordOfDayToDetail(word.id)
                findNavController().navigate(action)
            }
        }

        binding.btnRefresh.setOnClickListener {
            viewModel.refreshWord()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.word.collect { word ->
                    binding.progressBar.isVisible = word == null
                    binding.contentGroup.isVisible = word != null

                    word?.let {
                        binding.tvEsWord.text = it.esWord
                        binding.tvTrMeaning.text = it.trMeaning
                        binding.tvPartOfSpeech.text = it.partOfSpeech
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
