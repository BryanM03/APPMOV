package com.crespoboop.examen

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(navController: NavHostController, texto:String?,
                 texto2: String?, texto3:String?, texto4: String?){
    //  val state=viewModel.state

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Consulta individual") }
        )
    }) { padding ->
    Box(modifier = Modifier.fillMaxSize().
        padding(padding),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = "Nombre: ${texto}",
                style = MaterialTheme.typography.h6
            )
            //Spacer(modifier = Modifier.padding(12.dp))
            Text(
                text = "Categoria: ${texto2}",
                style = MaterialTheme.typography.h6
            )
            Text(
                text = "Habitacion: ${texto3}",
                style = MaterialTheme.typography.h6
            )

            Text(
                text = "Descripcion: ${texto4}",
                style = MaterialTheme.typography.h6
            )

        }
        }
    }
}