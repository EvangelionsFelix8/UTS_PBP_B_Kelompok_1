package com.example.uts_pbp_b_kelompok_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uts_pbp_b_kelompok_1.Database.Database;
import com.example.uts_pbp_b_kelompok_1.Model.User;
import com.example.uts_pbp_b_kelompok_1.Preferences.UserPreferences;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private TextInputLayout textUsername, textPassword;
    private UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userPreferences = new UserPreferences(LoginActivity.this);

        textUsername = findViewById(R.id.inputLoginUsername);
        textPassword = findViewById(R.id.inputLoginPassword);

        TextView textLink = findViewById(R.id.textLink);
        btnLogin = findViewById(R.id.btnLogin);

        checkLogin();

        textLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateForm()){
                    attemptLogin(textUsername.getEditText().getText().toString().trim(), textPassword.getEditText().getText().toString().trim());
                }
            }
        });
    }

    private void attemptLogin(String username, String password){

        class AttemptLogin extends AsyncTask<Void, Void, User> {
            @Override
            protected User doInBackground(Void... voids) {

                User user = Database.getInstance(LoginActivity.this)
                        .getDatabase()
                        .userDao()
                        .attemptLogin(username,password);

                return user;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);
                if(user == null){
                    Toast.makeText(LoginActivity.this, "Username atau password salah", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "Berhasil login", Toast.LENGTH_SHORT).show();
                    userPreferences.setLogin(user.getIduser(),user.getFullName(), user.getUsername(),user.getPassword(), user.getAlamat(), String.valueOf(user.getProfilePicture()));
                }
                checkLogin();

            }

        }

        AttemptLogin attemptLogin = new AttemptLogin();
        attemptLogin.execute();
    }

    private boolean validateForm(){
        if(textUsername.getEditText().getText().toString().trim().isEmpty() || textPassword.getEditText().getText().toString().trim().isEmpty()){
            Toast.makeText(LoginActivity.this, "Username atau Password Kosong !!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void checkLogin(){
        if(userPreferences.checkLogin()){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
    }
}