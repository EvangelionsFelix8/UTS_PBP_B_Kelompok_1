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
    void insertTicket(TicketRoom ticketRoom);

    @Update
    void updateTicket(TicketRoom ticketRoom);

    @Delete
    void deleteTicket(TicketRoom ticketRoom);

    @Query("SELECT * FROM ticket where id_user = :user_id")
    List<TicketRoom> getTodosByUserId(int user_id);
}
