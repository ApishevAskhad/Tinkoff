package ru.askhad.apishev.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.askhad.apishev.model.Payload;
import ru.askhad.apishev.model.Title;

@Database(entities = {Title.class, Payload.class}, version = 1)
public abstract class NewsDb extends RoomDatabase {
    public abstract NewsDao getTitlesDao();
}
