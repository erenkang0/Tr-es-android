package com.tr_es.dict.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tr_es.dict.data.local.entity.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(words: List<WordEntity>)

    @Query("SELECT * FROM words WHERE id = :id")
    suspend fun getWordById(id: Long): WordEntity?

    @Query("""
        SELECT words.* FROM words
        JOIN words_fts ON words.rowid = words_fts.rowid
        WHERE words_fts MATCH 'es_word:' || :query || '*'
        ORDER BY words.es_word ASC
        LIMIT :limit
    """)
    fun searchByEsWord(query: String, limit: Int = 50): Flow<List<WordEntity>>

    @Query("""
        SELECT words.* FROM words
        JOIN words_fts ON words.rowid = words_fts.rowid
        WHERE words_fts MATCH 'tr_meaning:' || :query || '*'
        ORDER BY words.es_word ASC
        LIMIT :limit
    """)
    fun searchByTrMeaning(query: String, limit: Int = 50): Flow<List<WordEntity>>

    @Query("SELECT COUNT(*) FROM words")
    suspend fun getCount(): Int

    @Query("SELECT * FROM words ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandomWord(): WordEntity?

    @Query("SELECT * FROM words ORDER BY RANDOM() LIMIT :limit")
    suspend fun getRandomWords(limit: Int): List<WordEntity>

    @Query("SELECT * FROM words ORDER BY id LIMIT 1 OFFSET :offset")
    suspend fun getWordByOffset(offset: Int): WordEntity?

    @Query("SELECT * FROM words WHERE id = :id")
    fun observeWordById(id: Long): Flow<WordEntity?>
}
