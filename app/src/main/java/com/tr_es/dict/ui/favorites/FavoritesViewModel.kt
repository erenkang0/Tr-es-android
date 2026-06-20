package com.tr_es.dict.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tr_es.dict.data.local.entity.WordEntity
import com.tr_es.dict.data.repository.DictionaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val repository: DictionaryRepository
) : ViewModel() {

    val favorites: StateFlow<List<WordEntity>> = repository.getFavoriteWords()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun removeFavorite(wordId: Long) {
        viewModelScope.launch {
            repository.toggleFavorite(wordId, currentlyFavorite = true)
        }
    }
}
