package com.example.myapplication34.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.myapplication34.data.dao.LoginAndPassDao;

@Database(entities = {UserDataModel.class,LoginAndPassModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public  abstract LoginAndPassDao loginAndPassDao();
}
