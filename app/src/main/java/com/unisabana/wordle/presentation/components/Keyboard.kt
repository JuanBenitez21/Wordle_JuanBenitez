package com.unisabana.wordle.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun key(char: String, onPress: (String) -> Unit){
    Box(
        modifier = Modifier
            .padding(2.dp)
            .background(color = Color(0xFF404752))
            .padding(10.dp)
            .clickable {
                // función
                onPress(char)
            }
    )
    {
        Text(char, color = Color.White, fontSize = 20.sp)
    }
}

@Composable
fun Keyboard(onPress: (String) -> Unit){
    val row1="QWERTYUIOP"
    val row2="ASDFGHJKLÑ"
    val row3="←ZXCVBNM↵"

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row {
            for(key in row1){
                key(key.toString(), onPress)
            }
        }

        Row {
            for(key in row2){
                key(key.toString(), onPress)
            }
        }

        Row {
            for(key in row3){
                key(key.toString(), onPress)
            }
        }
    }
}
@Preview(
    showBackground = true
)
@Composable
fun PreviewKeyboard(){
    Keyboard(onPress = {

    })
}