package com.example.uts_pbp_b_kelompok_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.uts_pbp_b_kelompok_1.databinding.ActivityDetailEventBinding;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;

import java.util.ArrayList;

public class DetailEventActivity extends AppCompatActivity{

    Event event;
    ActivityDetailEventBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_event);

//        Ambil Data Intent
        String strEvent = getIntent().getStringExtra("detailEvent");
        Gson gson = new Gson();
        event = gson.fromJson(strEvent, Event.class);

//        Inisialisasi objek dan variable ke data binding
        binding.setEvent(event);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //onBackPressed();
            }
        });

        MaterialButton btnPesanTiket = findViewById(R.id.btnPesanTiket);
        btnPesanTiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailEventActivity.this, OrderActivity.class);;
                startActivity(intent);
            }
        });
    }
}
