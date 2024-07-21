package com.openfinteacher.man.data.models

data class QuizQuestion(
    val question:String,
    val image:Int,
    val answerList: List<String>,
    val rightAnswer:Int
)
