package com.tr_es.dict.data.repository

import com.tr_es.dict.data.local.dao.FavoriteDao
import com.tr_es.dict.data.local.dao.WordDao
import com.tr_es.dict.data.local.entity.FavoriteEntity
import com.tr_es.dict.data.local.entity.WordEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

enum class SearchDirection { ES_TO_TR, TR_TO_ES }

@Singleton
class DictionaryRepository @Inject constructor(
    private val wordDao: WordDao,
    private val favoriteDao: FavoriteDao
) {

    fun search(query: String, direction: SearchDirection): Flow<List<WordEntity>> {
        val sanitized = query.trim().replace("'", "''")
        return if (direction == SearchDirection.ES_TO_TR) {
            wordDao.searchByEsWord(sanitized)
        } else {
            wordDao.searchByTrMeaning(sanitized)
        }
    }

    suspend fun getWordById(id: Long): WordEntity? = wordDao.getWordById(id)

    fun observeWordById(id: Long): Flow<WordEntity?> = wordDao.observeWordById(id)

    fun getFavoriteWords(): Flow<List<WordEntity>> = favoriteDao.getFavoriteWords()

    fun isFavorite(wordId: Long): Flow<Boolean> = favoriteDao.isFavorite(wordId)

    suspend fun toggleFavorite(wordId: Long, currentlyFavorite: Boolean) {
        if (currentlyFavorite) {
            favoriteDao.removeFavorite(wordId)
        } else {
            favoriteDao.addFavorite(FavoriteEntity(wordId = wordId))
        }
    }

    suspend fun getRandomWord(): WordEntity? = wordDao.getRandomWord()

    suspend fun getWordCount(): Int = wordDao.getCount()
}
