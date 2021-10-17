package com.example.uts_pbp_b_kelompok_1.Preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.uts_pbp_b_kelompok_1.Model.User;

public class UserPreferences {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

//    Definisi Key
    public static final String IS_LOGIN = "isLogin";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";

    public UserPreferences(Context context){
        this.context = context;

        sharedPreferences = context.getSharedPreferences("userPreferencees", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setLogin(String username, String password){
//        Menyimpan data login ke sharedPreferences dengan key
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_PASSWORD, password);

        editor.commit();
    }

    public User getUserLogin(){
//        Mengembalikan objek user untuk menampilkan data user
        String username, password, name, email;

        username = sharedPreferences.getString(KEY_USERNAME, null);
        password = sharedPreferences.getString(KEY_PASSWORD, null);
        name = sharedPreferences.getString(KEY_NAME, null);
        email = sharedPreferences.getString(KEY_EMAIL, null);

        return new User(username, password, name, email);
    }

    public boolean checkLogin(){
//        Mengembalikan nilai IS_LOGIN, jika sudah login, maka otomatis nilai true, jika tidak akan return false
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public void logout(){
//        Melakukan clear data yang ada pada sharedPreferences, jangan lupa dicommit agar data terubah
        editor.clear();
        editor.commit();
    }
}
