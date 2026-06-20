package com.tr_es.dict.ui.wordofday

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tr_es.dict.data.local.entity.WordEntity
import com.tr_es.dict.data.repository.DictionaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class WordOfDayViewModel @Inject constructor(
    private val repository: DictionaryRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val prefs = context.getSharedPreferences("word_of_day", Context.MODE_PRIVATE)

    private val _word = MutableStateFlow<WordEntity?>(null)
    val word: StateFlow<WordEntity?> = _word

    init {
        loadWordOfDay()
    }

    private fun loadWordOfDay() {
        viewModelScope.launch {
            val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            val savedDate = prefs.getString("date", null)
            val savedId = prefs.getLong("word_id", -1L)

            if (savedDate == today && savedId != -1L) {
                _word.value = repository.getWordById(savedId)
            } else {
                val randomWord = repository.getRandomWord()
                randomWord?.let {
                    prefs.edit()
                        .putString("date", today)
                        .putLong("word_id", it.id)
                        .apply()
                    _word.value = it
                }
            }
        }
    }

    fun refreshWord() {
        viewModelScope.launch {
            val randomWord = repository.getRandomWord()
            randomWord?.let {
                val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
                prefs.edit()
                    .putString("date", today)
                    .putLong("word_id", it.id)
                    .apply()
                _word.value = it
            }
        }
    }
}
