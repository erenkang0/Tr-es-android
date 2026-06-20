package com.tr_es.dict.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tr_es.dict.data.local.dao.FavoriteDao
import com.tr_es.dict.data.local.dao.WordDao
import com.tr_es.dict.data.local.entity.FavoriteEntity
import com.tr_es.dict.data.local.entity.WordEntity
import com.tr_es.dict.data.local.entity.WordFtsEntity

@Database(
    entities = [WordEntity::class, WordFtsEntity::class, FavoriteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DictionaryDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao
    abstract fun favoriteDao(): FavoriteDao
}
