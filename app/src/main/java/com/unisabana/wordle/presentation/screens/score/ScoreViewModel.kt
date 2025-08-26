package com.unisabana.wordle.presentation.screens.score


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unisabana.wordle.data.Score
import com.unisabana.wordle.data.ScoreRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class ScoreViewModel(
    private val scoreRepository: ScoreRepository
) : ViewModel() {

    // Exponer las listas de scores como StateFlows
    val scoresByScoreDesc: StateFlow<List<Score>> = scoreRepository.getAllScoresByScoreDesc()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    val scoresByDateAsc: StateFlow<List<Score>> = scoreRepository.getAllScoresByDateAsc()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    val scoresByDateDesc: StateFlow<List<Score>> = scoreRepository.getAllScoresByDateDesc()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )
}