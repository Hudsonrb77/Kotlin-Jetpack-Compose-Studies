package com.developerandroid.todoapp.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.developerandroid.todoapp.data.Task
import com.developerandroid.todoapp.components.BackButton
import kotlinx.coroutines.flow.collectLatest
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(navController: NavController, taskList: MutableList<Task>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF4A90E2), Color(0xFF50E3C2))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = "Adicionar Tarefa",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 40.dp)
            )

            // Criando um estado separado para cada campo
            var title by remember { mutableStateOf("") }
            var description by remember { mutableStateOf("") }
            var data by remember { mutableStateOf("") }
            var startTime by remember { mutableStateOf("") }
            var endTime by remember { mutableStateOf("") }


            SimpleOutlinedTextField("Título", title) { title = it }
            SimpleOutlinedTextField("Descrição", description) { description = it }
            SimpleOutlinedTextField("Horario de Início", startTime) { startTime = it }
            SimpleOutlinedTextField("Horario de Fim", endTime) { endTime = it }


            var openDatePicker by remember{mutableStateOf(false)}
            TextField(
                value = data, onValueChange = {},
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),

                label = {
                    Text("Data")
                },
                interactionSource = remember {
                    MutableInteractionSource() // Para pegar as interações e mapaear os cliques(se aconteceram ou não)
                }.also {// Serve para acessar o objeto, após o remember.
                    LaunchedEffect(it){ // Usamos esse corroutine para executar apenas quando tiver uma mudança de iteração.
                        it.interactions.collectLatest { interaction ->
                            if (interaction is PressInteraction.Release) {
                                openDatePicker = true
                            }

                        }
                    }
                },
                readOnly = true

            )
            val state = rememberDatePickerState()
            AnimatedVisibility(openDatePicker){
                DatePickerDialog(
                    onDismissRequest = { // Para quando eu clicar fora do datapicker
                        openDatePicker = false
                    },
                    confirmButton = {
                        Button(onClick = {
                            state.selectedDateMillis?.let { millis ->

                                data = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(
                                    Date(millis)
                                ) // Define um formato de data no padrão "dd/MM/yyyy"
                                // Converte os milissegundos selecionados pelo DatePicker em uma data formatada
                            }
                            openDatePicker = false
                        }) {
                            Text("Confirmar")
                        }
                    }
                ) {
                    DatePicker(state)
                }
            }


            Button(
                onClick = {
                    taskList.add(Task(title, description, data, startTime, endTime))
                    navController.popBackStack()
                },
                shape = RoundedCornerShape(22.dp),
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 3.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text("Salvar Tarefa", color = Color(0xFF4A90E2), fontWeight = FontWeight.SemiBold)
            }

            // Botão de voltar
            BackButton(navController = navController)
        }
    }
}


@Composable
fun SimpleOutlinedTextField(title: String, stringTask: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        value = stringTask,
        onValueChange = { onValueChange(it) },
        label = { Text(title) },
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF4A90E2),
            unfocusedBorderColor = Color(0xFFB3E5FC)
        )
    )
}
