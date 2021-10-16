package com.example.uts_pbp_b_kelompok_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class DetailEventActivity extends AppCompatActivity{
    private MaterialButton btnPesanTiket;
  /*  private TextView tvNameEventDetail;
    private TextView tvDateDetail;
    private  TextView tvVenueDetail;
    private TextView tvAddressDetail;
    private TextView tvPriceDetail; */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);
       /* tvNameEventDetail = findViewById(R.id.tvEventNameDetail);
        tvDateDetail = findViewById(R.id.tvEventDateDetail);
        tvVenueDetail = findViewById(R.id.tvEventVenueDetail);
        tvAddressDetail = findViewById(R.id.tvEventAddressDetail);
        tvPriceDetail = findViewById(R.id.tvEventPriceDetail); */
    }

}
