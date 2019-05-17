package ru.askhad.apishev.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import ru.askhad.apishev.model.Title;

@Dao
public interface TitlesDao {
    @Query("SELECT * FROM titles")
    List<Title> getTitles();
}
