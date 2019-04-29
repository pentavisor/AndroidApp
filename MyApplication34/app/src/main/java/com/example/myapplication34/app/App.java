package com.example.myapplication34.app;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.myapplication34.data.AppDatabase;

public final class App extends Application {

    private static App instance;

    private AppDatabase database;

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;
//        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database").allowMainThreadQueries()
//                .build();
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database")
                .fallbackToDestructiveMigration()//удаляет старую базу если нет путей миграции
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() { return database; }
}
