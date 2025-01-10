package com.developerandroid.mywishlistapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(viewModel: WishViewModel = viewModel(),
               navController: NavHostController = rememberNavController()){

    NavHost(
        navController= navController,
        startDestination = Screen.HomeScreen.route
    ){
        //Nessa parte teremos as nossas telas criadas. Ex:(Tela de Cadastro, Tela de Login e etc)
        composable(Screen.HomeScreen.route){
            HomeView(navController, viewModel)
        }

        composable(Screen.AddScreen.route){
            AddEditDetailView(id = 0L, viewModel = viewModel, navController = navController)
        }
    }

}