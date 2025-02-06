package com.developerandroid.todoapp.data

data class Task(
    val title: String,
    var description: String = "",
    var data: String = "",
    var startTime: String = "",
    var endTime: String = ""
)
