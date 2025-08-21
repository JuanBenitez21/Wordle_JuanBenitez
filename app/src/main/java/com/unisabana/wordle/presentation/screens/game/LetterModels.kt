package com.unisabana.wordle.presentation.screens.game

enum class LetterState {
    CORRECT,   // Verde
    PRESENT,   // Amarillo
    ABSENT,    // Gris
    DEFAULT    // Vacío
}

data class Cell(
    val letter: Char = ' ',
    val state: LetterState = LetterState.DEFAULT
)