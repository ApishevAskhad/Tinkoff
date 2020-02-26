package ru.apishev.askhad.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.apishev.askhad.data.database.entity.ContentEntity
import ru.apishev.askhad.data.database.entity.TitleEntity

@Database(entities = [TitleEntity::class, ContentEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun appDao(): AppDao
}
