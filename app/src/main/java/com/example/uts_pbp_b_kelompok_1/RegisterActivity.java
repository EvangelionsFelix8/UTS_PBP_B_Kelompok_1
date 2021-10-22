package com.example.uts_pbp_b_kelompok_1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
                String nama = textNama.getEditText().getText().toString();
                String email = textEmail.getEditText().getText().toString();
                String username = textUsername.getEditText().getText().toString();
                String password = textPassword.getEditText().getText().toString();

                if(nama.trim().isEmpty() || email.trim().isEmpty() || username.trim().isEmpty() || password.trim().isEmpty()){
                    if(nama.trim().isEmpty()){
                        textNama.setError("Nama must be filled with text");
                    }
                    if(email.isEmpty()){
                        textEmail.setError("Email must be filled with text");
                    }
                    if(username.isEmpty()){
                        textUsername.setError("Username must be filled with text");
                    }
                    if(password.isEmpty()){
                        textPassword.setError("Password must be filled with text");
                    }
                }
                else{
                    register(textNama.getEditText().getText().toString(),textEmail.getEditText().getText().toString().trim(), textUsername.getEditText().getText().toString().trim(), textPassword.getEditText().getText().toString().trim());
                    Toast.makeText(RegisterActivity.this, "Berhasil Register Akun !", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void register(String name, String email, String username, String password){

        class RegisterUser extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                User user = new User();
                user.setFullName(name);
                user.setEmail(email);
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