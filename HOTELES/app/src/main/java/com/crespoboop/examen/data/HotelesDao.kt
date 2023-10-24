package com.crespoboop.examen.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface HotelesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertProyectoHoteles(proyectohoteles:HotelesEntity)

    @Query("SELECT * FROM HotelesEntity")
    suspend fun getProyectosHoteles():List<HotelesEntity>


}