package com.example.uts_pbp_b_kelompok_1.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.uts_pbp_b_kelompok_1.Entity.TicketRoom;
import com.example.uts_pbp_b_kelompok_1.Model.User;

import java.util.List;


@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<User> getAll();

    @Query("SELECT * FROM users WHERE username=:username AND password=:password")
    User attemptLogin(String username, String password);

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Query("UPDATE users SET full_name = :fullName, username=:username, email=:email, alamat=:alamat WHERE id_user = :iduser")
    void updateUser(String fullName, String username, String email, String alamat, int iduser);


}
