package com.unisabana.wordle.data

import kotlinx.coroutines.flow.Flow
import java.sql.Timestamp

class ScoreRepository (private val scoreDao: ScoreDao){

    fun getAllScores(): Flow<List<Score>> = scoreDao.getAllScores()

    suspend fun addScore(
        score: Int,
        name: String,
        count: Int,
        isWinner: Boolean,
        solution: String,
       // atCreated: Timestamp
    ){
        scoreDao.insertScore(Score(score=score, name=name, count=count,isWinner=isWinner,solution=solution ))//atCreated=atCreated))

       // scoreDao.insertScore(Score(id,score, name, count,isWinner,solution,atCreated))
    }

    // All logic


}