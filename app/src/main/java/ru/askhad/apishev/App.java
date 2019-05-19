package ru.askhad.apishev;

import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

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
