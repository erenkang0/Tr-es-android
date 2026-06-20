package com.tr_es.dict

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tr_es.dict.data.local.DictionaryDatabase
import com.tr_es.dict.data.local.DatabaseSeeder
import com.tr_es.dict.data.local.entity.WordEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DictionaryDatabaseTest {

    private lateinit var db: DictionaryDatabase

    @Before
    fun setup() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            DictionaryDatabase::class.java
        ).allowMainThreadQueries().build()
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun insert_and_query_word() = runBlocking {
        val word = WordEntity(
            esWord = "casa",
            trMeaning = "ev",
            partOfSpeech = "isim"
        )
        db.wordDao().insertAll(listOf(word))

        val results = db.wordDao().searchByEsWord("cas").first()
        assertEquals(1, results.size)
        assertEquals("ev", results[0].trMeaning)
    }

    @Test
    fun seed_data_loads() = runBlocking {
        db.wordDao().insertAll(DatabaseSeeder.words)
        val count = db.wordDao().getCount()
        assertNotNull(db.wordDao().getRandomWord())
        assert(count > 0) { "Kelime sayısı 0 olmamalı" }
    }
}
