package com.tr_es.dict.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "words",
    indices = [
        Index(value = ["es_word"]),
        Index(value = ["tr_meaning"])
    ]
)
data class WordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "es_word") val esWord: String,
    @ColumnInfo(name = "tr_meaning") val trMeaning: String,
    @ColumnInfo(name = "part_of_speech") val partOfSpeech: String = "",
    @ColumnInfo(name = "examples") val examples: String? = null,
    @ColumnInfo(name = "pronunciation") val pronunciation: String? = null
)
