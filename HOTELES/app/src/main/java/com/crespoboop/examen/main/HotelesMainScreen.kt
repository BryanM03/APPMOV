package com.crespoboop.examen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HotelesMainScreen(navController: NavController, viewModel: HotelesMainViewModel) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Ingreso de datos")})
        }
    ) {padding ->


        val state = viewModel.state
        Column(
            modifier = Modifier
                .padding()
                .fillMaxWidth()
                .padding(10.dp, 50.dp, 10.dp, 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Nombre:Bryan Steven Mejía Landa ")
            Text(text = "Entidad: Hoteles")
            Text(text = "Curso: 7B")
            OutlinedTextField(value = state.nombre, onValueChange = { viewModel.onNombreChange(it) },
            label = { Text(text = "Nombre del Hotel")})
            OutlinedTextField(value = state.categoria, onValueChange = { viewModel.onCategoriaChange(it) },
                label = { Text(text = "Categoria del Hotel")})
            OutlinedTextField(value = state.habitacion, onValueChange = {viewModel.onHabitacionChange(it)},
                label = { Text(text = "Habitación")})
            OutlinedTextField(value = state.descripcion, onValueChange = {viewModel.onDescripcionChange(it)},
                label = { Text(text = "Descripción del habitación")})
            Button(onClick = { viewModel.saveProyectoHoteles() }) {
                Text(text = "Crear", fontSize = 18.sp)
            }

            Button(onClick = { navController.navigate("lista") }) {
                Text(text = "ver listado")
            }
        }
    }
}