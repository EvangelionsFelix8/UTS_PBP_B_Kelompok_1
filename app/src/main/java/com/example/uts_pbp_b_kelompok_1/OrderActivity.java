package com.example.uts_pbp_b_kelompok_1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.Insert;

import com.example.uts_pbp_b_kelompok_1.Database.Database;
import com.example.uts_pbp_b_kelompok_1.Entity.TicketRoom;
import com.example.uts_pbp_b_kelompok_1.Model.User;
import com.example.uts_pbp_b_kelompok_1.databinding.ActivityDetailEventBinding;
import com.example.uts_pbp_b_kelompok_1.databinding.ActivityOrderBinding;
import com.google.gson.Gson;

public class OrderActivity extends AppCompatActivity {
    Event event;
    ActivityOrderBinding binding;
    Spinner spinnerSeat;
    Spinner spinnerSection;
    Spinner spinnerTime;
    ImageButton btnBack;
    Button btnPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order);

        String strEvent = getIntent().getStringExtra("detailEvent");
        Gson gson = new Gson();
        event = gson.fromJson(strEvent, Event.class);

        binding.setEvent(event);

        btnPesan = findViewById(R.id.btnPesan);
        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertTicket();
            }
        });

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }

    private void insertTicket(){
        final String eventName = event.getNamaEvent();
        final String eventDate = event.getTanggalEvent();
        final String eventVenue = event.getVenueEvent();
        final String eventAlamat = event.getAlamatEvent();
        final String seatSection= spinnerSection.getSelectedItem().toString();
        final String seatNumber = spinnerSeat.getSelectedItem().toString();
        final String eventTime = spinnerTime.getSelectedItem().toString();

        class InsertTicket extends AsyncTask<Void,Void,Void>{

            @Override
            protected Void doInBackground(Void... voids) {
                TicketRoom ticketRoom = new TicketRoom();
                ticketRoom.setEventName(eventName);
                ticketRoom.setEventDate(eventDate);
                ticketRoom.setEventVenue(eventVenue);
                ticketRoom.setEventAddress(eventAlamat);
                ticketRoom.setTime(eventTime);
                ticketRoom.setSeatSection(seatSection);
                ticketRoom.setSeatNumber(seatNumber);

                Database.getInstance(getApplicationContext())
                        .getDatabase()
                        .ticketDao()
                        .insertTicket(ticketRoom);
                return null;
            }

            @Override
            protected void onPostExecute(Void unused){
                super.onPostExecute(unused);
                Toast.makeText(OrderActivity.this,"Berhasil memesan tiket",Toast.LENGTH_SHORT).show();

            }
        }
        InsertTicket insertTicket = new InsertTicket();
        insertTicket.execute();
        //Intent intent = new Intent(OrderActivity.this, MainActivity.class);;
        //startActivity(intent);
    }
}
