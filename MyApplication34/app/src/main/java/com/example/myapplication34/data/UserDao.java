package com.example.myapplication34.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user_list")
    List<UserDataModel> getAll();

    @Query("SELECT * FROM user_list WHERE id IN (:userIds)")
    List<UserDataModel> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user_list WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    UserDataModel findByName(String first, String last);

    @Query("SELECT * FROM user_list WHERE first_name LIKE :first LIMIT 1")
    Maybe<UserDataModel> findByNameAsin(String first);

    @Insert
    void insertAll(UserDataModel... users);

    @Delete
    void delete(UserDataModel user);
}
