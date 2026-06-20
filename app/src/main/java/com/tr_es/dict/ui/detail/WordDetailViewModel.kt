package com.tr_es.dict.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tr_es.dict.data.local.entity.WordEntity
import com.tr_es.dict.data.repository.DictionaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class Example(val es: String, val tr: String)

data class WordDetailUiState(
    val word: WordEntity? = null,
    val isFavorite: Boolean = false,
    val examples: List<Example> = emptyList()
)

@HiltViewModel
class WordDetailViewModel @Inject constructor(
    private val repository: DictionaryRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val wordId: Long = savedStateHandle["wordId"] ?: 0L
    private val gson = Gson()

    val uiState: StateFlow<WordDetailUiState> = combine(
        repository.observeWordById(wordId),
        repository.isFavorite(wordId)
    ) { word, isFavorite ->
        val examples = parseExamples(word?.examples)
        WordDetailUiState(word = word, isFavorite = isFavorite, examples = examples)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = WordDetailUiState()
    )

    fun toggleFavorite() {
        viewModelScope.launch {
            repository.toggleFavorite(wordId, uiState.value.isFavorite)
        }
    }

    private fun parseExamples(json: String?): List<Example> {
        if (json.isNullOrBlank()) return emptyList()
        return try {
            val type = object : TypeToken<List<Example>>() {}.type
            gson.fromJson(json, type)
        } catch (e: Exception) {
            emptyList()
        }
    }
}
