package com.crespoboop.examen.data

import com.crespoboop.examen.main.Hotel

class HotelesRepository (private val hotelesDao: HotelesDao){
    suspend fun getProyectosHoteles(): List<Hotel> {
        val entities = hotelesDao.getProyectosHoteles()
        return entities.map {
            Hotel(nombre = it.nombre, categoria = it.categoria, habitacion = it.habitacion, descripcion = it.descripcion)
        }
    }

    suspend fun insertProyectoHoteles(hoteles: Hotel) {
        val entity = HotelesEntity(nombre = hoteles.nombre, categoria = hoteles.categoria, habitacion = hoteles.habitacion, descripcion = hoteles.descripcion)
        hotelesDao.insertProyectoHoteles(entity)
    }
}