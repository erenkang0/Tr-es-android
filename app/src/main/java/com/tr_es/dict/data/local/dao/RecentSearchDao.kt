package com.tr_es.dict.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tr_es.dict.data.local.entity.RecentSearchEntity
import com.tr_es.dict.data.local.entity.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecentSearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun record(entry: RecentSearchEntity)

    @Query("""
        SELECT words.* FROM words
        INNER JOIN recent_searches ON words.id = recent_searches.word_id
        ORDER BY recent_searches.searched_at DESC
        LIMIT :limit
    """)
    fun getRecentWords(limit: Int): Flow<List<WordEntity>>

    @Query("DELETE FROM recent_searches")
    suspend fun clear()
}
