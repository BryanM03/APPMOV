package com.crespoboop.examen.main

data class HotelesMainState(
    val nombre: String="",
    val categoria: String="",
    val habitacion: String="",
    val descripcion: String="",
    val nombres: List<Hotel> = emptyList()
)


