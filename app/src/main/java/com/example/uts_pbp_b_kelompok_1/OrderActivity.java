package com.example.uts_pbp_b_kelompok_1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.uts_pbp_b_kelompok_1.databinding.ActivityOrderBinding;
import com.google.gson.Gson;

public class OrderActivity extends AppCompatActivity {

    private ImageButton btnBack;
    Event event;
    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_order);

        String strEvent = getIntent().getStringExtra("detailEvent");
        Gson gson = new Gson();
        event = gson.fromJson(strEvent, Event.class);

        binding.setEvent(event);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

//        Spinner spinnerSection = findViewById(R.id.spinnerSection);
//        spinnerSection.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(OrderActivity.this,"Selected"+spinnerSection.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        Spinner spinnerSeat = findViewById(R.id.spinnerSeatNumber);
//        spinnerSeat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(OrderActivity.this,"Selected"+spinnerSeat.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}
