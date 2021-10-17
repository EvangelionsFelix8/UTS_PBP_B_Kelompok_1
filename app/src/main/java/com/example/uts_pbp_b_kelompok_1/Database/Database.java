package com.example.uts_pbp_b_kelompok_1.Database;

import android.content.Context;

import androidx.room.Room;

public class Database {
    private Context context;
    private static Database database;

    private AppDatabase appdatabase;

    public Database(Context context){
        this.context = context;
        appdatabase = Room.databaseBuilder(context, AppDatabase.class, "eservicedb").allowMainThreadQueries().build();
    }

    public static synchronized Database getInstance(Context context){
        if(database == null){
            database = new Database(context);
        }
        return database;
    }

    public AppDatabase getDatabase() { return appdatabase; }
}
