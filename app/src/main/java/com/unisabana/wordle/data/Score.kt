package com.unisabana.wordle.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(
    tableName = "scores"
)
data class Score(
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    // All you can do
    val score: Int,
    val name: String,
    val count: Int,
    val isWinner: Boolean,
    val solution: String,
   // val atCreated: Timestamp
)

