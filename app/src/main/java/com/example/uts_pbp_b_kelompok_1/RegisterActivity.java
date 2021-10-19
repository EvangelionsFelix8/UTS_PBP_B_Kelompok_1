package com.example.uts_pbp_b_kelompok_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uts_pbp_b_kelompok_1.Database.Database;
import com.example.uts_pbp_b_kelompok_1.Model.User;
import com.example.uts_pbp_b_kelompok_1.Preferences.UserPreferences;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout textNama, textEmail, textUsername, textPassword;
    private Button btnRegister;
    private UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userPreferences = new UserPreferences(RegisterActivity.this);

        textNama = findViewById(R.id.inputRegisName);
        textEmail = findViewById(R.id.inputRegisEmail);
        textUsername = findViewById(R.id.inputRegisUsername);
        textPassword = findViewById(R.id.inputRegisPassword);
        TextView textLink = findViewById(R.id.textLink);
        btnRegister = findViewById(R.id.btnRegister);

        textLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register(textNama.getEditText().getText().toString(), textUsername.getEditText().getText().toString().trim(), textPassword.getEditText().getText().toString().trim());
                Toast.makeText(RegisterActivity.this, "Berhasil Register Akun !", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void register(String name,String username, String password){

        class RegisterUser extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                User user = new User();
                user.setFullName(name);
                user.setUsername(username);
                user.setPassword(password);

                Database.getInstance(RegisterActivity.this)
                        .getDatabase()
                        .userDao()
                        .insertUser(user);

                return null;
            }

            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                finish();
            }

        }

        RegisterUser registerUser = new RegisterUser();
        registerUser.execute();
    }
}