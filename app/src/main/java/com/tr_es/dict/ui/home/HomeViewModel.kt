package com.tr_es.dict.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tr_es.dict.data.local.entity.WordEntity
import com.tr_es.dict.data.repository.DictionaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: DictionaryRepository
) : ViewModel() {

    private val _wordOfDay = MutableStateFlow<WordEntity?>(null)
    val wordOfDay: StateFlow<WordEntity?> = _wordOfDay.asStateFlow()

    private val _flashcardCount = MutableStateFlow(FLASHCARD_SIZE)
    val flashcardCount: StateFlow<Int> = _flashcardCount.asStateFlow()

    val recent: StateFlow<List<WordEntity>> = repository.getRecentSearches(10)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    init {
        viewModelScope.launch {
            _wordOfDay.value = repository.getWordOfDay()
        }
        viewModelScope.launch {
            _flashcardCount.value = repository.getWordCount().coerceAtMost(FLASHCARD_SIZE)
        }
    }

    companion object {
        private const val FLASHCARD_SIZE = 15
    }
}
