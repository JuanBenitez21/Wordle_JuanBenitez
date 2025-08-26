package com.unisabana.wordle.presentation.screens.score

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.unisabana.wordle.data.Score
import com.unisabana.wordle.presentation.screens.game.GameViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScoreScreen(onBack: () -> Unit, viewModel: GameViewModel = viewModel()) {
    Scaffold(
        containerColor = Color.Black,
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Scores")
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(1.dp))

            // Tabla 1: Ordenada por puntaje (descendente)
            ScoreTable(title = "Top Scores", viewModel.scoresByScoreDesc.collectAsState().value)

            Spacer(modifier = Modifier.height(1.dp))

            // Tabla 2: Ordenada por fecha de creación (ascendente)
            ScoreTable(title = "Oldest Games", viewModel.scoresByDateAsc.collectAsState().value)

            Spacer(modifier = Modifier.height(1.dp))

            Button(onClick = {
                onBack()
            },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Return to home!")
            }
            // Tabla 3: Ordenada por fecha de creación (descendente)
            ScoreTable(title = "Recent Games", viewModel.scoresByDateDesc.collectAsState().value)

            Spacer(modifier = Modifier.height(0.dp))


        }
    }
}

@Composable
fun ScoreTable(title: String, scores: List<Score>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Player", color = Color.White, fontSize = 16.sp)
            Text(text = "Score", color = Color.White, fontSize = 16.sp)
            Text(text = "Attempts", color = Color.White, fontSize = 16.sp)
            Text(text = "Date", color = Color.White, fontSize = 16.sp)
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Define una altura fija para cada tabla
        ) {
            items(scores) { score ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = score.name, color = Color.White, fontSize = 16.sp)
                    Text(text = score.score.toString(), color = Color.White, fontSize = 16.sp)
                    Text(text = score.count.toString(), color = Color.White, fontSize = 16.sp)
                    // Formato de fecha
                    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    val dateString = dateFormat.format(Date(score.atCreated))
                    Text(text = dateString, color = Color.White, fontSize = 16.sp)
                }
            }
        }
    }
}