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
import com.tr_es.dict.R
import com.tr_es.dict.databinding.FragmentWordDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WordDetailFragment : Fragment() {

    private var _binding: FragmentWordDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WordDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabFavorite.setOnClickListener {
            viewModel.toggleFavorite()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    state.word?.let { word ->
                        binding.tvEsWord.text = word.esWord
                        binding.tvTrMeaning.text = word.trMeaning
                        binding.chipPartOfSpeech.text = word.partOfSpeech
                        binding.chipPartOfSpeech.isVisible = word.partOfSpeech.isNotBlank()

                        val pronunciationText = word.pronunciation
                        binding.tvPronunciation.text = pronunciationText
                        binding.tvPronunciation.isVisible = !pronunciationText.isNullOrBlank()
                    }

                    val favIcon = if (state.isFavorite) {
                        R.drawable.ic_favorite_filled
                    } else {
                        R.drawable.ic_favorite_outline
                    }
                    binding.fabFavorite.setImageResource(favIcon)

                    binding.examplesContainer.removeAllViews()
                    state.examples.forEach { example ->
                        val exampleView = layoutInflater.inflate(
                            R.layout.item_example,
                            binding.examplesContainer,
                            false
                        )
                        val tvEs = exampleView.findViewById<android.widget.TextView>(R.id.tv_example_es)
                        val tvTr = exampleView.findViewById<android.widget.TextView>(R.id.tv_example_tr)
                        tvEs.text = example.es
                        tvTr.text = example.tr
                        binding.examplesContainer.addView(exampleView)
                    }
                    binding.tvExamplesLabel.isVisible = state.examples.isNotEmpty()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
