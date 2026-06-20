package com.tr_es.dict.di

import android.content.Context
import androidx.room.Room
import com.tr_es.dict.data.local.DatabaseSeeder
import com.tr_es.dict.data.local.DictionaryDatabase
import com.tr_es.dict.data.local.dao.FavoriteDao
import com.tr_es.dict.data.local.dao.WordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DictionaryDatabase {
        val db = Room.databaseBuilder(
            context,
            DictionaryDatabase::class.java,
            "tr_es_dict.db"
        ).build()

        CoroutineScope(Dispatchers.IO).launch {
            if (db.wordDao().getCount() == 0) {
                db.wordDao().insertAll(DatabaseSeeder.words)
            }
        }

        return db
    }

    @Provides
    fun provideWordDao(db: DictionaryDatabase): WordDao = db.wordDao()

    @Provides
    fun provideFavoriteDao(db: DictionaryDatabase): FavoriteDao = db.favoriteDao()
}
