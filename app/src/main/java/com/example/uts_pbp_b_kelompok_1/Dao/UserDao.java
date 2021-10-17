package com.example.uts_pbp_b_kelompok_1.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.uts_pbp_b_kelompok_1.Entity.UserRoom;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<UserRoom> getAll();

    @Insert
    void insertUser(UserRoom user);

    @Update
    void updateUser(UserRoom user);

    @Delete
    void deleteUser(UserRoom user);
}
