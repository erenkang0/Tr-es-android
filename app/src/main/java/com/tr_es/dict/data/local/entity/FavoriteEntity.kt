package com.tr_es.dict.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "favorites",
    foreignKeys = [ForeignKey(
        entity = WordEntity::class,
        parentColumns = ["id"],
        childColumns = ["word_id"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["word_id"], unique = true)]
)
data class FavoriteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "word_id") val wordId: Long,
    @ColumnInfo(name = "added_at") val addedAt: Long = System.currentTimeMillis()
)
