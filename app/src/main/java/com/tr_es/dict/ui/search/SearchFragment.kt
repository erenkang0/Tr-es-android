package com.tr_es.dict.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = WordAdapter { word ->
            val action = SearchFragmentDirections.actionSearchToDetail(word.id)
            findNavController().navigate(action)
        }
        binding.recyclerView.adapter = adapter

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?) = false
            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.onQueryChanged(newText.orEmpty())
                return true
            }
        })

        binding.btnToggleDirection.setOnClickListener {
            viewModel.toggleDirection()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    adapter.submitList(state.results)

                    binding.tvEmptyState.isVisible =
                        !state.isIdle && state.results.isEmpty()
                    binding.tvHint.isVisible = state.isIdle

                    val dirLabel = if (state.direction == SearchDirection.ES_TO_TR)
                        getString(R.string.direction_es_tr)
                    else
                        getString(R.string.direction_tr_es)
                    binding.btnToggleDirection.text = dirLabel

                    val hint = if (state.direction == SearchDirection.ES_TO_TR)
                        getString(R.string.hint_search_es)
                    else
                        getString(R.string.hint_search_tr)
                    binding.searchView.queryHint = hint
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
