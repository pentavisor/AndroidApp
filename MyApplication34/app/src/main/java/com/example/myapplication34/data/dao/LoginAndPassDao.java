package com.example.myapplication34.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.myapplication34.data.LoginAndPassModel;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface LoginAndPassDao {
    @Query("SELECT * FROM login_and_pass  LIMIT 1")
    Maybe<LoginAndPassModel> findFirstEntry();

    @Query("DELETE FROM login_and_pass")
    void deleteAll();

    @Insert
    void insertAll(LoginAndPassModel... users);

    @Delete
    void delete(LoginAndPassModel user);
}
