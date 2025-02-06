package com.developerandroid.todoapp.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun BackButton(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { navController.popBackStack() },
        shape = CircleShape,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4A90E2))
    ) {
        Icon(
            contentDescription = "Voltar",
            imageVector = Icons.AutoMirrored.Filled.ArrowBack
        )
    }
}