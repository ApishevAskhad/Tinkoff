package ru.askhad.apishev.di

import androidx.room.Room
import ru.apishev.askhad.data.database.AppDatabase
import ru.askhad.apishev.App

object ServiceLocator {

    private const val DATABASE_NAME = "news_db"

    val appContext by lazy {
        App.instance
    }

    val database by lazy {
        Room.databaseBuilder(appContext, AppDatabase::class.java, DATABASE_NAME)
                .build()
    }

    val dataInteractor = DataInteractorImpl(database)
}
