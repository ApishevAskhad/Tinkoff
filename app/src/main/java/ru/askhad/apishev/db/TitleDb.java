package ru.askhad.apishev.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ru.askhad.apishev.model.Title;

@Database(entities = {Title.class}, version = 1)
public abstract class TitleDb extends RoomDatabase {
    public abstract TitlesDao getTitlesDao();
}
