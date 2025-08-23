package com.unisabana.wordle.presentation.screens.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.unisabana.wordle.presentation.components.AlertDialogExample
import com.unisabana.wordle.presentation.components.Grid
import com.unisabana.wordle.presentation.components.Keyboard
import com.unisabana.wordle.ui.theme.WordleTheme


@Composable
fun Estado(gameViewModel: GameViewModel){
    if (gameViewModel.isShowModal){
        AlertDialogExample(onConfirmation = {gameViewModel.hideModal()},
            onDismissRequest = {gameViewModel.hideModal()},
            dialogTitle = "Felicidades ha gando",
            dialogText = "En "+ "x"+ "intentos",
            icon = Icons.Filled.Done,)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(onBack: () -> Unit, gameViewModel: GameViewModel = viewModel()) {
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
        Column (modifier = Modifier.padding(innerPadding)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp)
        )
        {
            Spacer(modifier = Modifier.height(30.dp))

            Grid(
                gameViewModel::current.get(),
                gameViewModel::solution.get(),
                gameViewModel::attempts.get(),
            )

            Keyboard { key ->
                when (key) {
                    "←" -> gameViewModel.onRemoveLetter()
                    "↵" -> gameViewModel.onSubmit()
                    else -> gameViewModel.onKeyPressed(key.first())
                }
            }
            Button(
                onClick = {
                    // Go to ScoreDestination
                    onBack()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6AAA65)
                )
            ) {
                Text("Scores", color = Color.White)
            }
        }
        Estado(gameViewModel)
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewGameScreen(){
    WordleTheme {
        GameScreen(onBack = {})
    }

}