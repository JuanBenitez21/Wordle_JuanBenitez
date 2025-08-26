package com.unisabana.wordle.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.unisabana.wordle.presentation.screens.game.GameViewModel
/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScoreScreen(onBack: () -> Unit, gameViewModel: GameViewModel) {
    Scaffold (containerColor = Color.Black,
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Game Screen")
                }
            )
        },

        ){
            innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ){
            Spacer(modifier = Modifier.height(32.dp)) // espacio entre TopBar y lista

            val scores = listOf(
                "Name one - score",
                "Name two - score",
                "Name one - score",
                "Name two - score",
                "Name one - score",
                "Name two - score",
                "Name one - score",
                "Name two - score"
            )

            scores.forEachIndexed { index, item ->
                Text(
                    text = "${index + 1}. $item",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = {
                onBack()
            }) {
                Text("Back!")
            }
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewScoreScreen(){
    ScoreScreen(
        onBack = {},
        gameViewModel = GameViewModel()
    )
}

 */

@Composable
fun ScoreScreen(onBack: () -> Unit, viewModel: GameViewModel) {
    Scaffold {
            innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding)
        ){
            Button({
                onBack()
            }) {
                Text("Return to home!")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScoreScreen(){
    ScoreScreen (onBack={}, viewModel = viewModel())
}