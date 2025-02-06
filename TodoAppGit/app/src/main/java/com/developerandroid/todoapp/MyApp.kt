package com.developerandroid.todoapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.developerandroid.todoapp.data.Task
import com.developerandroid.todoapp.screens.AddScreen
import com.developerandroid.todoapp.screens.HomeScreen
import com.developerandroid.todoapp.screens.ScreenTaskEdit

@Composable
fun MyApp(){
    val navController = rememberNavController()
    val taskList = remember { mutableStateListOf<Task>() }

    NavHost(
        navController = navController,
        startDestination = Routes.screenhome)
    {
        composable(Routes.screenhome){
            HomeScreen(navController, taskList)
        }
        composable(Routes.screentask) {
            ScreenTaskEdit(navController, taskList)
        }
        composable(Routes.addtaskscreen){
            AddScreen(navController, taskList)
        }
    }
}