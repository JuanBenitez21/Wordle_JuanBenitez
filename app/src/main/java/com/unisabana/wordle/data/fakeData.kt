package com.unisabana.wordle.data

val words = arrayOf(
    "casae",
    "luzco",
    "nubes",
    "perro",
    "gatos",
    "flore",
    "tigre",
    "salud",
    "mango",
    "rueda"
)


fun getRandomWord(): String{
    return words.random()
}

// firebase
// supbase
// server in site