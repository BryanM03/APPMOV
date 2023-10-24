package com.crespoboop.examen.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HotelesEntity::class], version = 1)
abstract class HotelesDatabase: RoomDatabase() {

    abstract val dao: HotelesDao
}