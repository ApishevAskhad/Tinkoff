package ru.askhad.apishev.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import ru.askhad.apishev.model.Content;
import ru.askhad.apishev.model.Title;

@Dao
public interface NewsDao {
    @Query("SELECT * FROM titles")
    List<Title> getTitles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTitles(List<Title> titles);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertContent(Content content);
}
