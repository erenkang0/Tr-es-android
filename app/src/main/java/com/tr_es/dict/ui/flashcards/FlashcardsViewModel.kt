package com.tr_es.dict.ui.flashcards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tr_es.dict.data.local.entity.WordEntity
import com.tr_es.dict.data.repository.DictionaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class FlashState(
    val deck: List<WordEntity> = emptyList(),
    val index: Int = 0,
    val showBack: Boolean = false,
    val finished: Boolean = false,
    val loading: Boolean = true
)

@HiltViewModel
class FlashcardsViewModel @Inject constructor(
    private val repository: DictionaryRepository
) : ViewModel() {

    private val _state = MutableStateFlow(FlashState())
    val state: StateFlow<FlashState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val deck = repository.getFlashcardDeck(15)
            _state.update {
                it.copy(
                    deck = deck,
                    index = 0,
                    showBack = false,
                    finished = false,
                    loading = false
                )
            }
        }
    }

    /** Front <-> back of the current card. */
    fun flip() {
        _state.update { it.copy(showBack = !it.showBack) }
    }

    /** Advance to the next card. [known] is recorded by the caller's intent; either way we move on. */
    fun answer(known: Boolean) {
        _state.update { current ->
            if (current.deck.isEmpty()) return@update current
            if (current.index + 1 >= current.deck.size) {
                current.copy(finished = true, showBack = false)
            } else {
                current.copy(index = current.index + 1, showBack = false)
            }
        }
    }

    /** Reset to the start with a freshly drawn deck. */
    fun restart() {
        _state.update {
            it.copy(index = 0, showBack = false, finished = false, loading = true)
        }
        viewModelScope.launch {
            val deck = repository.getFlashcardDeck(15)
            _state.update {
                it.copy(
                    deck = deck,
                    index = 0,
                    showBack = false,
                    finished = false,
                    loading = false
                )
            }
        }
    }

    /** Word currently on top of the deck, or null when out of range. */
    val current: WordEntity?
        get() = _state.value.deck.getOrNull(_state.value.index)
}
