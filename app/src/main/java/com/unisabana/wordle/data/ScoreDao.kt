package com.unisabana.wordle.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow

@Dao
interface ScoreDao {

    @Query("SELECT * FROM scores")
    fun getAllScores(): Flow<List<Score>>

    @Insert
    suspend fun insertScore(score: Score)

}
/*
suspend fun coruotineExample(){
    delay(1000);
}
 */