package com.unisabana.wordle.presentation.screens.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.unisabana.wordle.data.Score
import com.unisabana.wordle.data.ScoreRepository
import com.unisabana.wordle.data.getRandomWord
import kotlinx.coroutines.launch
import java.sql.Timestamp


class GameViewModel(
    private val scoreRepository: ScoreRepository
    ) : ViewModel(){
    // Variables
    var solution by mutableStateOf(getRandomWord())
        private set
    var attempts by mutableStateOf(listOf<String>())
        private set
    var score by mutableIntStateOf(0)
        private set
    var current by mutableStateOf("")

    var isShowModal by mutableStateOf(false)
        private set

    var isShowLose by mutableStateOf(false)
        private set

    var finalScore by mutableIntStateOf(0)
        private set


    //Funs
    fun showModal(){
        isShowModal =true
    }
    fun hideModal(){
        isShowModal=false
    }
    fun restartGame() {
        solution = getRandomWord()
        current = ""
        attempts = emptyList()
        isShowModal = false // Reinicia el estado del modal
        isShowLose = false  // Reinicia el estado de perder
    }


    fun onSubmit() {
        if (current.length == 5 && attempts.size < 6) {
            attempts = attempts + current

            if (current.equals(solution, ignoreCase = true)) {
                // Se calcula el puntaje final y se guarda en la variable 'finalScore'
                finalScore = calculateFinalScore(attempts.size)
                showModal()
                // La llamada a `calculateScore()` ya usa `finalScore`
                calculateScore()
                return
            }

            if (attempts.size == 6) {
                isShowLose = true
            } else {
                current = ""
                // No incrementamos 'score' aquí, ya que el cálculo se hace al ganar.
            }
        }
    }


    fun onKeyPressed(letter: Char) {
        // Solo permite agregar letras si el juego no ha terminado y la palabra no está completa
        if (current.length < 5 && !isShowModal && !isShowLose) {
            current += letter
        }
    }

    fun onRemoveLetter() {
        if (current.isNotEmpty() && !isShowModal && !isShowLose) {
            current = current.dropLast(1)
        }
    }

    private fun calculateFinalScore(attemptsCount: Int): Int {
        return when (attemptsCount) {
            1 -> 100
            2 -> 80
            3 -> 60
            4 -> 40
            5 -> 20
            6 -> 10
            else -> 0
        }
    }

    fun calculateScore() {
        val finalScore = calculateFinalScore(attempts.size)
        viewModelScope.launch {
            scoreRepository.addScore(
                score = finalScore,
                name = "",
                count = attempts.size,
                isWinner = true,
                solution = solution,
            )
        }
    }
}