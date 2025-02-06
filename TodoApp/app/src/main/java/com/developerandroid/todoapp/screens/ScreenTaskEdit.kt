package com.developerandroid.todoapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.developerandroid.todoapp.components.BackButton
import com.developerandroid.todoapp.data.Task

@Composable
fun ScreenTaskEdit(navController: NavController, taskList: MutableList<Task>) {

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){

        Text("hudson")

        BackButton(navController = navController)
    }
}