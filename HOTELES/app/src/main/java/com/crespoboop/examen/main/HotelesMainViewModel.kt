package com.crespoboop.examen.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crespoboop.examen.data.HotelesRepository
import kotlinx.coroutines.launch

class HotelesMainViewModel(private val repository: HotelesRepository): ViewModel() {


    var state by mutableStateOf(HotelesMainState())
        private set

    init {
        viewModelScope.launch {
            state=state.copy(
                nombres = repository.getProyectosHoteles()
            )
        }

    }

    fun onNombreChange(nombre: String){
        state=state.copy(
            nombre=nombre
        )

    }



    fun onCategoriaChange(categoria: String){
        state=state.copy(
            categoria = categoria
        )
    }

    fun onHabitacionChange(habitacion: String){
        state=state.copy(
            habitacion=habitacion
        )
    }

    fun onDescripcionChange(descripcion: String){
        state=state.copy(
            descripcion = descripcion
        )

    }

    fun saveProyectoHoteles(){
        val hoteles= Hotel(
            nombre=state.nombre,
            categoria = state.categoria,
            habitacion = state.habitacion,
             descripcion= state.descripcion
        )

        viewModelScope.launch {
            repository.insertProyectoHoteles(hoteles)
        }
    }

}