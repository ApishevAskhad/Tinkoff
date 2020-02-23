package ru.apishev.askhad.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun appDao(): AppDao
}
