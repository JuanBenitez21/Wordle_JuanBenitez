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
fun Grid99(current: String, solution: String, attempts: List<String>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        for (rowIndex in 0 until 6) {
            val word = when {
                rowIndex < attempts.size -> attempts[rowIndex]  // palabras jugadas
                rowIndex == attempts.size -> current            // palabra en construcción
                else -> ""                                     // filas vacías
            }

            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                for (colIndex in 0 until 5) {
                    val char = word.getOrNull(colIndex)?.toString() ?: ""

                    val blockType = when {
                        rowIndex < attempts.size -> { // Palabra ya enviada
                            when {
                                solution[colIndex] == char.firstOrNull() -> CellType.GREEN
                                char.isNotEmpty() && solution.contains(char) -> CellType.YELLOW
                                char.isNotEmpty() -> CellType.GREY
                                else -> CellType.TRANSPARENT
                            }
                        }
                        else -> { // Palabra actual o vacía
                            if (char.isNotEmpty()) CellType.TRANSPARENT else CellType.TRANSPARENT
                        }
                    }

                    Cell2(char, blockType)
                }
            }
        }
    }
}

private fun evaluateColors(solution: String, guess: String): List<CellType> {
    val sol = solution.uppercase()
    val g = guess.uppercase()
    val n = 5

    val result = MutableList(n) { CellType.GREY }
    val used = BooleanArray(n) { false }

    // 1ª pasada: verdes
    for (i in 0 until n) {
        if (i < g.length && g[i] == sol[i]) {
            result[i] = CellType.GREEN
            used[i] = true
        }
    }

    // contar disponibles en solución (no usados en verde)
    val remaining = mutableMapOf<Char, Int>()
    for (i in 0 until n) {
        if (!used[i]) {
            remaining[sol[i]] = (remaining[sol[i]] ?: 0) + 1
        }
    }

    // 2ª pasada: amarillos
    for (i in 0 until n) {
        if (i < g.length && result[i] == CellType.GREY) {
            val c = g[i]
            val count = remaining[c] ?: 0
            if (count > 0) {
                result[i] = CellType.YELLOW
                remaining[c] = count - 1
            }
        }
    }
    return result
}

@Composable
fun Grid(current: String, solution: String, attempts: List<String>) {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        for (rowIndex in 0 until 6) {
            val word = when {
                rowIndex < attempts.size -> attempts[rowIndex]
                rowIndex == attempts.size -> current
                else -> ""
            }

            val colors: List<CellType> = if (rowIndex < attempts.size && word.length == 5) {
                evaluateColors(solution, word)
            } else {
                List(5) { if (rowIndex == attempts.size && word.isNotEmpty()) CellType.TRANSPARENT else CellType.TRANSPARENT }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                for (colIndex in 0 until 5) {
                    val ch = word.getOrNull(colIndex)?.toString() ?: ""
                    val cellType = if (rowIndex < attempts.size) colors[colIndex] else CellType.TRANSPARENT
                    // Para la fila actual mostramos borde transparente (sin color de fondo)
                    if (rowIndex == attempts.size) {
                        Cell3(ch, CellType.TRANSPARENT)
                    } else {
                        Cell2(ch, cellType)
                    }
                }
            }
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