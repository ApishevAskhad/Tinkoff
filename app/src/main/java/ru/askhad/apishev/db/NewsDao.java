package ru.askhad.apishev.db;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import ru.askhad.apishev.model.Payload;
import ru.askhad.apishev.model.Title;

@Dao
public interface NewsDao {
    @Query("SELECT * FROM titles")
    List<Title> getTitles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTitles(List<Title> titles);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertContent(Payload content);
}
