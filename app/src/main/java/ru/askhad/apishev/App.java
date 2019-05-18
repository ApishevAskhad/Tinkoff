package ru.askhad.apishev;

import android.app.Application;
import android.arch.persistence.room.Room;

import ru.askhad.apishev.db.NewsDb;

public class App extends Application {
    private NewsDb db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(), NewsDb.class, "news_db")
            .allowMainThreadQueries()
            .build();
    }

    public NewsDb getDb() {
        return db;
    }
}
