package com.tr_es.dict.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.tr_es.dict.NavGraphDirections
import com.tr_es.dict.R
import com.tr_es.dict.data.repository.SearchDirection
import com.tr_es.dict.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SearchViewModel by viewModels()
    private lateinit var adapter: WordAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = WordAdapter { word ->
            viewModel.recordSearch(word.id)
            findNavController().navigate(
                NavGraphDirections.actionGlobalWordDetail(word.id)
            )
        }
        binding.recyclerView.adapter = adapter

        binding.etSearch.addTextChangedListener { text ->
            viewModel.onQueryChanged(text?.toString().orEmpty())
        }

        binding.btnDir.setOnClickListener {
            viewModel.toggleDirection()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    adapter.submitList(state.results)

                    binding.tvHint.isVisible = state.isIdle
                    binding.tvEmpty.isVisible = !state.isIdle && state.results.isEmpty()
                    binding.recyclerView.isVisible =
                        !state.isIdle && state.results.isNotEmpty()

                    binding.btnDir.setText(
                        if (state.direction == SearchDirection.ES_TO_TR) {
                            R.string.direction_es_tr
                        } else {
                            R.string.direction_tr_es
                        }
                    )

                    binding.etSearch.setHint(
                        if (state.direction == SearchDirection.ES_TO_TR) {
                            R.string.hint_search_es
                        } else {
                            R.string.hint_search_tr
                        }
                    )
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
