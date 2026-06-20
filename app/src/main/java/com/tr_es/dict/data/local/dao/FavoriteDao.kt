package com.tr_es.dict.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tr_es.dict.data.local.entity.FavoriteEntity
import com.tr_es.dict.data.local.entity.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavorite(favorite: FavoriteEntity)

    @Query("DELETE FROM favorites WHERE word_id = :wordId")
    suspend fun removeFavorite(wordId: Long)

    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE word_id = :wordId)")
    fun isFavorite(wordId: Long): Flow<Boolean>

    @Query("""
        SELECT words.* FROM words
        INNER JOIN favorites ON words.id = favorites.word_id
        ORDER BY favorites.added_at DESC
    """)
    fun getFavoriteWords(): Flow<List<WordEntity>>
}
