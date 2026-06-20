package com.tr_es.dict.ui.detail

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
import com.tr_es.dict.R
import com.tr_es.dict.databinding.FragmentWordDetailBinding
import com.tr_es.dict.databinding.ItemExampleBinding
import com.tr_es.dict.util.SpeechHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WordDetailFragment : Fragment() {

    private var _binding: FragmentWordDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WordDetailViewModel by viewModels()

    private var speech: SpeechHelper? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val speech = SpeechHelper(requireContext())
        this.speech = speech

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnFav.setOnClickListener {
            viewModel.toggleFavorite()
        }

        binding.btnAudio.setOnClickListener {
            viewModel.uiState.value.word?.let { word ->
                speech.speak(word.esWord)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state -> render(state) }
            }
        }
    }

    private fun render(state: WordDetailUiState) {
        val b = _binding ?: return

        state.word?.let { word ->
            b.tvEsWord.text = word.esWord

            val pronunciation = word.pronunciation
            b.tvPronunciation.text = pronunciation
            b.tvPronunciation.isVisible = !pronunciation.isNullOrBlank()

            b.tvPos.text = word.partOfSpeech
            b.tvPos.isVisible = word.partOfSpeech.isNotBlank()

            b.tvTrMeaning.text = word.trMeaning
        }

        b.btnFav.setImageResource(
            if (state.isFavorite) R.drawable.ic_favorite_filled
            else R.drawable.ic_favorite_outline
        )

        b.examplesContainer.removeAllViews()
        state.examples.forEach { ex ->
            val itemBinding = ItemExampleBinding.inflate(
                layoutInflater,
                b.examplesContainer,
                false
            )
            itemBinding.tvExampleEs.text = ex.es
            itemBinding.tvExampleTr.text = ex.tr
            b.examplesContainer.addView(itemBinding.root)
        }
        b.tvExamplesLabel.isVisible = state.examples.isNotEmpty()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        speech?.shutdown()
        speech = null
        _binding = null
    }
}
