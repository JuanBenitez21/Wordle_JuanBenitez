package com.unisabana.wordle.presentation.screens.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.unisabana.wordle.data.getRandomWord

class GameViewModel : ViewModel(){
    // Variables
    var solution by mutableStateOf(getRandomWord())
        private set
    var attempts by mutableStateOf(listOf<String>())
        private set
    var score by mutableIntStateOf(0)
        private set
    var current by mutableStateOf("")

    var isShowModal by mutableStateOf(false)
        private set



    //Funs
    fun showModal(){
        isShowModal =true
    }
    fun hideModal(){
        isShowModal=false
    }
    fun restartGame(){
        solution= getRandomWord()
        current = ""
        attempts = emptyList()
    }

    fun onSubmit(){

        // TO do
        if(current.equals(solution)){
            isShowModal = true
            print("Felicidades esa es la palabra")
            println("Buneaaa")
        }
        if(current.length ==5){
            attempts = attempts + current
            current = ""
            score++
        }

    }

    fun onKeyPressed(letter: Char){
        if(current.length <=4){
            current += letter
        }

    }

    fun onRemoveLetter(){
        if (current.isNotEmpty()) {
            current = current.dropLast(1)
        }
    }



}