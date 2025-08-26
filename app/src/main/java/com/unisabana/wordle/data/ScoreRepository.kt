package com.unisabana.wordle.data

import kotlinx.coroutines.flow.Flow
import java.sql.Timestamp
/*
class ScoreRepository(private val scoreDao: ScoreDao) {

    fun getAllScores(): Flow<List<Score>> = scoreDao.getAllScores()

    suspend fun addScore(
        score: Int,
        name: String,
        count: Int,
        isWinner: Boolean,
        solution: String,
    ) {
        val atCreated = Timestamp(System.currentTimeMillis()) // Genera el Timestamp aquí
        scoreDao.insertScore(
            Score(
                score = score,
                name = name,
                count = count,
                isWinner = isWinner,
                solution = solution,
                atCreated = atCreated.time // Guarda el Long en la BD
            )
        )
    }
}

 */

class ScoreRepository(private val scoreDao: ScoreDao) {

    fun getAllScores(): Flow<List<Score>> = scoreDao.getAllScores()
    fun getAllScoresByScoreDesc(): Flow<List<Score>> = scoreDao.getAllScoresByScoreDesc()
    fun getAllScoresByDateAsc(): Flow<List<Score>> = scoreDao.getAllScoresByDateAsc()
    fun getAllScoresByDateDesc(): Flow<List<Score>> = scoreDao.getAllScoresByDateDesc()

    suspend fun addScore(
        score: Int,
        name: String,
        count: Int,
        isWinner: Boolean,
        solution: String,
    ) {
        val atCreated = Timestamp(System.currentTimeMillis())
        scoreDao.insertScore(
            Score(
                score = score,
                name = name,
                count = count,
                isWinner = isWinner,
                solution = solution,
                atCreated = atCreated.time
            )
        )
    }
}