package com.tr_es.dict.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tr_es.dict.data.local.entity.WordEntity
import com.tr_es.dict.data.repository.DictionaryRepository
import com.tr_es.dict.data.repository.SearchDirection
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: DictionaryRepository
) : ViewModel() {

    data class SearchUiState(
        val results: List<WordEntity> = emptyList(),
        val direction: SearchDirection = SearchDirection.ES_TO_TR,
        val isIdle: Boolean = true
    )

    private val queryFlow = MutableStateFlow("")
    private val directionFlow = MutableStateFlow(SearchDirection.ES_TO_TR)

    val uiState: StateFlow<SearchUiState> = combine(queryFlow, directionFlow) { q, d ->
        q to d
    }
        .debounce(300)
        .flatMapLatest { (q, d) ->
            if (q.trim().length < 2) {
                flowOf(SearchUiState(direction = d, isIdle = true))
            } else {
                repository.search(q, d).map { results ->
                    SearchUiState(results = results, direction = d, isIdle = false)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            SearchUiState()
        )

    fun onQueryChanged(q: String) {
        queryFlow.value = q
    }

    fun toggleDirection() {
        directionFlow.value = if (directionFlow.value == SearchDirection.ES_TO_TR) {
            SearchDirection.TR_TO_ES
        } else {
            SearchDirection.ES_TO_TR
        }
    }

    fun recordSearch(id: Long) {
        viewModelScope.launch {
            repository.recordSearch(id)
        }
    }
}
