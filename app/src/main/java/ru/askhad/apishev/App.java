package ru.askhad.apishev;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import ru.askhad.apishev.db.NewsDb;

public class App extends Application {
    private NewsDb db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(), NewsDb.class, "news_db")
            .addMigrations(new Migration(1, 2) {
                @Override
                public void migrate(@NonNull SupportSQLiteDatabase database) {
                    
                }
            })
            .allowMainThreadQueries()
            .build();
    }

    public NewsDb getDb() {
        return db;
    }
}
