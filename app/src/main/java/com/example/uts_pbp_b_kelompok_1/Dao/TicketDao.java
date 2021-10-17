package com.example.uts_pbp_b_kelompok_1.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.uts_pbp_b_kelompok_1.Entity.TicketRoom;

import java.util.List;

@Dao
public interface TicketDao {
    @Query("SELECT * FROM ticket")
    List<TicketRoom> getAll();

    @Insert
    void insertTicket(TicketRoom ticket);

    @Update
    void updateTicket(TicketRoom ticket);

    @Delete
    void deleteTicket(TicketRoom ticket);
}
