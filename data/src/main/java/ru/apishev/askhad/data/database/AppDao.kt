package ru.apishev.askhad.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import io.reactivex.Single
import ru.apishev.askhad.data.database.entity.TitleEntity

@Dao
interface AppDao {
    @Query("SELECT * FROM titles")
    fun getAllTitles(): Single<List<TitleEntity>>

    @Insert(onConflict = REPLACE)
    fun addTitle(title: TitleEntity): Long
}
