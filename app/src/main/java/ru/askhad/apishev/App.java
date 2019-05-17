package ru.askhad.apishev;

import android.app.Application;
import android.arch.persistence.room.Room;

import ru.askhad.apishev.db.TitleDb;

public class App extends Application {
    private TitleDb db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(), TitleDb.class, "titles_db")
            .allowMainThreadQueries()
            .build();
    }

    public TitleDb getDb() {
        return db;
    }
}
