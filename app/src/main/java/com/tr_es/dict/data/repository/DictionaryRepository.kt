package com.tr_es.dict.data.repository

import com.tr_es.dict.data.local.dao.FavoriteDao
import com.tr_es.dict.data.local.dao.RecentSearchDao
import com.tr_es.dict.data.local.dao.WordDao
import com.tr_es.dict.data.local.entity.FavoriteEntity
import com.tr_es.dict.data.local.entity.RecentSearchEntity
import com.tr_es.dict.data.local.entity.WordEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import javax.inject.Inject
import javax.inject.Singleton

enum class SearchDirection { ES_TO_TR, TR_TO_ES }

@Singleton
class DictionaryRepository @Inject constructor(
    private val wordDao: WordDao,
    private val favoriteDao: FavoriteDao,
    private val recentSearchDao: RecentSearchDao
) {

    // --- Arama ---
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

    suspend fun getWordCount(): Int = wordDao.getCount()

    // --- Favoriler ---
    fun getFavoriteWords(): Flow<List<WordEntity>> = favoriteDao.getFavoriteWords()

    fun isFavorite(wordId: Long): Flow<Boolean> = favoriteDao.isFavorite(wordId)

    suspend fun toggleFavorite(wordId: Long, currentlyFavorite: Boolean) {
        if (currentlyFavorite) {
            favoriteDao.removeFavorite(wordId)
        } else {
            favoriteDao.addFavorite(FavoriteEntity(wordId = wordId))
        }
    }

    // --- Son aramalar ---
    suspend fun recordSearch(wordId: Long) {
        recentSearchDao.record(RecentSearchEntity(wordId = wordId))
    }

    fun getRecentSearches(limit: Int = 10): Flow<List<WordEntity>> =
        recentSearchDao.getRecentWords(limit)

    suspend fun clearRecentSearches() = recentSearchDao.clear()

    // --- Günün kelimesi (güne göre deterministik) ---
    suspend fun getWordOfDay(): WordEntity? {
        val count = wordDao.getCount()
        if (count == 0) return null
        val offset = (LocalDate.now().toEpochDay() % count).toInt()
        return wordDao.getWordByOffset(offset) ?: wordDao.getRandomWord()
    }

    suspend fun getRandomWord(): WordEntity? = wordDao.getRandomWord()

    // --- Kart çalışması destesi (önce favoriler, yoksa rastgele) ---
    suspend fun getFlashcardDeck(size: Int = 15): List<WordEntity> {
        val favorites = favoriteDao.getFavoriteWordsOnce()
        return if (favorites.size >= size) {
            favorites.take(size)
        } else {
            val extra = wordDao.getRandomWords(size)
            (favorites + extra).distinctBy { it.id }.take(size)
        }
    }
}
