package com.unisabana.wordle.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.unisabana.wordle.presentation.screens.game.GameScreen
import com.unisabana.wordle.presentation.screens.HomeScreen
import com.unisabana.wordle.presentation.screens.ScoreScreen
import kotlinx.serialization.Serializable

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

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
                }
            )
        }
        composable<ScoreDestination> {
            ScoreScreen(
                onBack = {
                navController.popBackStack()
            })
        }
    }
}

@Serializable
object HomeDestination


@Serializable
object GameDestination

@Serializable
object ScoreDestination