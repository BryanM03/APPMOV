package com.crespoboop.examen.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HotelesEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val nombre: String,
    val categoria: String,
    val habitacion: String,
    val descripcion: String,

)