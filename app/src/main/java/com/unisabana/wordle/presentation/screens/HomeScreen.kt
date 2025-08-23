package com.unisabana.wordle.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.unisabana.wordle.presentation.components.AlertDialogExample
import com.unisabana.wordle.presentation.components.Example1
import com.unisabana.wordle.presentation.components.Example2
import com.unisabana.wordle.presentation.components.Example3
import com.unisabana.wordle.presentation.components.IconLogWordle
import com.unisabana.wordle.presentation.navigation.GameDestination
import com.unisabana.wordle.presentation.navigation.ScoreDestination

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        containerColor = Color.Black
    ) {
            innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
                .fillMaxSize()
                .paddingFromBaseline(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            IconLogWordle()
            Box(modifier = Modifier.fillMaxWidth()
                .paddingFromBaseline(60.dp),
                ){
                Column (modifier = Modifier
                    .align(Alignment.CenterStart) // Columna alineada a la izquierda
                    .padding(start = 46.dp),       // Margen izquierdo
                    verticalArrangement = Arrangement.spacedBy(6.dp)){
                    Text(
                        "How to play",
                        color = Color.White,
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Start,
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    Text("Guess the Wordle in 6 tries",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Left,

                        )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                            "• Each guess must be a valid 5-letter word.",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Left,
                    )
                    Text("• The color of the tiles will change to show how close your guess was to the word.",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 25.dp)
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Text("Examples",
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Start,
                        )
                    Example1()
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("W")
                            }
                            append(" is in the word and in the correct spot.")
                        },
                        color = Color.White,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Start
                    )
                    Example2()
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("I")
                            }
                            append(" is in the word but in the wrong spot.")
                        },
                        color = Color.White,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Start
                    )
                    Example3()
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("U")
                            }
                            append(" is not in the word in any spot.")
                        },
                        color = Color.White,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Start
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    // Go to GameDestination
                    navController.navigate(GameDestination)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6AAA65)
                )
            ) {
                Text("Play!", color = Color.White)
            }

            Button(
                onClick = {
                    // Go to ScoreDestination
                    navController.navigate(ScoreDestination)
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
    }
}

@Composable
fun Tutorial(){

}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen(){
    val navController = rememberNavController()
    HomeScreen(navController)

}