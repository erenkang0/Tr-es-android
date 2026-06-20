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
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

data class SearchUiState(
    val results: List<WordEntity> = emptyList(),
    val query: String = "",
    val direction: SearchDirection = SearchDirection.ES_TO_TR,
    val isIdle: Boolean = true
)

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: DictionaryRepository
) : ViewModel() {

    private val queryFlow = MutableStateFlow("")
    private val directionFlow = MutableStateFlow(SearchDirection.ES_TO_TR)

    val uiState: StateFlow<SearchUiState> = combine(
        queryFlow,
        directionFlow
    ) { query, direction -> query to direction }
        .debounce(300L)
        .flatMapLatest { (query, direction) ->
            if (query.length < 2) {
                flowOf(SearchUiState(query = query, direction = direction, isIdle = true))
            } else {
                repository.search(query, direction).map { results ->
                    SearchUiState(
                        results = results,
                        query = query,
                        direction = direction,
                        isIdle = false
                    )
                }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = SearchUiState()
        )

    fun onQueryChanged(query: String) {
        queryFlow.value = query
    }

    fun toggleDirection() {
        directionFlow.value = if (directionFlow.value == SearchDirection.ES_TO_TR) {
            SearchDirection.TR_TO_ES
        } else {
            SearchDirection.ES_TO_TR
        }
        // directionFlow değişimi combine'ı yeniden tetikler; ayrıca bir şey yapmaya gerek yok.
    }
}
