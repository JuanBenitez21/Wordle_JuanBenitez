package com.unisabana.wordle.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class CellType{
    GREEN,
    YELLOW,
    GREY,
    TRANSPARENT
}

@Composable
fun Cell(character: String, blockType:CellType){

    val backgroundColor = when (blockType){
        CellType.YELLOW -> Color(0xFFC9B457)
        CellType.GREEN -> Color(0xFF6AAA65)
        CellType.GREY -> Color(0xFF787C7F)
        else -> Color.Transparent
    }

    Box(
        modifier = Modifier
            .size(50.dp)
            .background(backgroundColor, shape = RoundedCornerShape(2.dp))
            .border(1.dp, Color.Black, RoundedCornerShape(2.dp)), // 👈 borde blanco/transparente

    contentAlignment = Alignment.Center
    ) { // -> Container -> div
        Text(character, fontSize = 26.sp, color = Color.White) // dp -> sp
    }
}

@Composable
fun Cell3(character: String, blockType:CellType){

    val backgroundColor = when (blockType){
        CellType.YELLOW -> Color(0xFFC9B457)
        CellType.GREEN -> Color(0xFF6AAA65)
        CellType.GREY -> Color(0xFF787C7F)
        else -> Color.Transparent
    }

    Box(
        modifier = Modifier
            .size(60.dp)
            .background(Color.Transparent, shape = RoundedCornerShape(2.dp))
            .border(1.dp, Color.White.copy(alpha = 0.5f), RoundedCornerShape(2.dp)),

        contentAlignment = Alignment.Center
    ) { // -> Container -> div
        Text(character, fontSize = 26.sp, color = Color.White) // dp -> sp
    }
}

@Composable
fun Cell2(character: String, blockType:CellType){

    val backgroundColor = when (blockType){
        CellType.YELLOW -> Color(0xFFC9B457)
        CellType.GREEN -> Color(0xFF6AAA65)
        CellType.GREY -> Color(0xFF787C7F)
        else -> Color.Transparent
    }

    Box(
        modifier = Modifier
            .size(50.dp)
            .background(backgroundColor, shape = RoundedCornerShape(2.dp))
            .border(2.dp, Color.White.copy(alpha = 0.5f), RoundedCornerShape(2.dp)),

        contentAlignment = Alignment.Center
    ) { // -> Container -> div
        Text(character, fontSize = 26.sp, color = Color.White, letterSpacing = 2.sp) // dp -> sp
    }
}
@Preview
@Composable
fun PreviewCellSuccess(){
    Column {
        Row{
            Cell("W", CellType.GREEN)
            Cell("O", CellType.GREY)
            Cell("R", CellType.YELLOW)
            Cell("D", CellType.GREEN)
            Cell("L", CellType.GREY)
            Cell("E", CellType.GREEN)
        }

        Row{
            Cell(" ", CellType.TRANSPARENT)
            Cell(" ", CellType.TRANSPARENT)
            Cell(" ", CellType.TRANSPARENT)
            Cell(" ", CellType.TRANSPARENT)
            Cell(" ", CellType.TRANSPARENT)
        }
    }
}
@Preview
@Composable
fun IconLogWordle(){
    Column {
        Row {
            Cell("W", CellType.GREEN)
            Cell("O", CellType.GREY)
            Cell("R", CellType.YELLOW)
            Cell("D", CellType.GREEN)
            Cell("L", CellType.GREY)
            Cell("E", CellType.GREEN)
        }
    }
}


@Composable
fun Grid(current: String, solution: String, attempts: List<String>) {

    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        for (i in 0..5)
            Row (
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ){
                for (i in 0..4)
                    Cell3("   ", CellType.GREY)
            }
    }
}

@Preview
@Composable
fun Example1(){
    Column {
        Row {
            Cell2("W", CellType.GREEN)
            Cell2("O", CellType.TRANSPARENT)
            Cell2("R", CellType.TRANSPARENT)
            Cell2("D", CellType.TRANSPARENT)
            Cell2("Y", CellType.TRANSPARENT)
        }
    }
}

@Preview
@Composable
fun Example2(){
    Column {
        Row {
            Cell2("L", CellType.TRANSPARENT)
            Cell2("I", CellType.YELLOW)
            Cell2("G", CellType.TRANSPARENT)
            Cell2("H", CellType.TRANSPARENT)
            Cell2("T", CellType.TRANSPARENT)
        }
    }
}

@Preview
@Composable
fun Example3(){
    Column {
        Row {
            Cell2("R", CellType.TRANSPARENT)
            Cell2("O", CellType.TRANSPARENT)
            Cell2("G", CellType.TRANSPARENT)
            Cell2("U", CellType.GREY)
            Cell2("E", CellType.TRANSPARENT)
        }
    }
}
//
//@Preview
//@Composable
//fun PreviewCellMissing(){
//    Cell("W", 0)
//}
//
//@Preview
//@Composable
//fun PreviewCellNoInWord(){
//    Cell("W", 2)
//}

// "basd" -> String
// 'a' -> Char


// String -> Char[]

// Hola -> H,O,L,A .toString()