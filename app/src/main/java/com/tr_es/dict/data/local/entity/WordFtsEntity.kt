package com.tr_es.dict.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4

@Fts4(contentEntity = WordEntity::class)
@Entity(tableName = "words_fts")
data class WordFtsEntity(
    @ColumnInfo(name = "es_word") val esWord: String,
    @ColumnInfo(name = "tr_meaning") val trMeaning: String
)
