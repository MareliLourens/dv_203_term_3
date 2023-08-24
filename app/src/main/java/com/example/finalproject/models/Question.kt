package com.example.finalproject.models

data class Question(
    val id:Int,
    val questionText: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: String
)
