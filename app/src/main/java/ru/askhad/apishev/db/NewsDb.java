package ru.askhad.apishev.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ru.askhad.apishev.model.Payload;
import ru.askhad.apishev.model.Title;

@Database(entities = {Title.class, Payload.class}, version = 1)
public abstract class NewsDb extends RoomDatabase {
    public abstract NewsDao getTitlesDao();
}
