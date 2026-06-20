package com.tr_es.dict

import com.tr_es.dict.data.local.DatabaseSeeder
import org.junit.Assert.assertTrue
import org.junit.Test

class DatabaseSeederTest {

    @Test
    fun seeder_contains_words() {
        assertTrue("Seed verisi boş olamaz", DatabaseSeeder.words.isNotEmpty())
    }

    @Test
    fun all_words_have_es_and_tr() {
        DatabaseSeeder.words.forEach { word ->
            assertTrue("es_word boş: $word", word.esWord.isNotBlank())
            assertTrue("tr_meaning boş: $word", word.trMeaning.isNotBlank())
        }
    }
}
