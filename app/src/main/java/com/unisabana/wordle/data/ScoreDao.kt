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


    @Query("SELECT * FROM scores ORDER BY score DESC")
    fun getAllScoresByScoreDesc(): Flow<List<Score>>

    @Query("SELECT * FROM scores ORDER BY atCreated ASC")
    fun getAllScoresByDateAsc(): Flow<List<Score>>

    @Query("SELECT * FROM scores ORDER BY atCreated DESC")
    fun getAllScoresByDateDesc(): Flow<List<Score>>

    @Insert
    suspend fun insertScore(score: Score)


}
/*
suspend fun coruotineExample(){
    delay(1000);
}
 */