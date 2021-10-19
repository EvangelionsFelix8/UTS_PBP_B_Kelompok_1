package com.example.uts_pbp_b_kelompok_1.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.uts_pbp_b_kelompok_1.Dao.TicketDao;
import com.example.uts_pbp_b_kelompok_1.Dao.UserDao;
import com.example.uts_pbp_b_kelompok_1.Entity.TicketRoom;
import com.example.uts_pbp_b_kelompok_1.Model.User;

@Database(entities = {User.class, TicketRoom.class}, version =2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract TicketDao ticketDao();
}
