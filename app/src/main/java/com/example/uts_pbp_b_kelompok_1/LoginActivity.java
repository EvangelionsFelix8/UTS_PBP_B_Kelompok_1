package com.example.uts_pbp_b_kelompok_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textLink = findViewById(R.id.textLink);

        textLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    //Coba Clone sm Update ya Lix :v (Christian)
//    Oke Monggo dicoba saja gpp :v ( Felix )
    // okee (christian)
    // test apakah masuk ;v (ravel)
}