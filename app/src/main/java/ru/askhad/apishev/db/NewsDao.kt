package ru.askhad.apishev.db

import androidx.room.Dao
import androidx.room.Query
import ru.askhad.apishev.model.Title

@Dao
interface NewsDao {
    @Query("SELECT * FROM titles")
    fun getTitles(): List<Title>
}