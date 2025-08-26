package com.unisabana.wordle.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.unisabana.wordle.data.ScoreRepository
import com.unisabana.wordle.data.WordleDatabase
import com.unisabana.wordle.presentation.screens.game.GameScreen
import com.unisabana.wordle.presentation.screens.HomeScreen
import com.unisabana.wordle.presentation.screens.score.ScoreScreen
import com.unisabana.wordle.presentation.screens.game.GameViewModel
import kotlinx.serialization.Serializable

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    val context= LocalContext.current
    val database = remember { WordleDatabase.getDatabase(context) }
    val repository = remember { ScoreRepository(database.ScoreDao()) }
    val gameViewModel= remember { GameViewModel(repository) }

    NavHost(
        navController = navController,
        startDestination = HomeDestination
    ){
        composable<HomeDestination> {
            HomeScreen(navController)
        }
        composable<GameDestination> {
            GameScreen(
                onBack = {
                    navController.popBackStack()
                },
                gameViewModel
            )
        }
        composable<ScoreDestination> {
            ScoreScreen(
                onBack = {
                navController.popBackStack()
            },
                gameViewModel
            )
        }
    }
}

@Serializable
object HomeDestination


@Serializable
object GameDestination

@Serializable
object ScoreDestination