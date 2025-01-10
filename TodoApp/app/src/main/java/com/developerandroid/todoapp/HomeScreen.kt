package com.developerandroid.todoapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(){
    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        item {
            Spacer(modifier = Modifier.height(100.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Column {
                    Text(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        text = "Lista de Tarefas",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        text = "Wednesday, 11 May",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }

                FilledTonalButton(
                    onClick = {},
                    shape = RoundedCornerShape(8.dp)

                ) {

                    Row {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Favorite",
                            modifier = Modifier.size(20.dp),
                            tint = Color.Blue
                        )

                        Text("New Task", color = Color.Blue)
                    }
                }

        }
            Spacer(modifier = Modifier.height(50.dp))
        }
        item {
            CustomCard_Task(
                "Client Review & Feedback",
                "Descrição da tarefa",
                "00:00",
                "02:00"
            )
        }
        items(5) { index ->
            CustomCard_Task(
                title = "Task $index",
                description = "Description for task $index",
                startTime = "0${index + 1}:00 AM",
                endTime = "0${index + 2}:00 AM"
            )
        }
    }
}
