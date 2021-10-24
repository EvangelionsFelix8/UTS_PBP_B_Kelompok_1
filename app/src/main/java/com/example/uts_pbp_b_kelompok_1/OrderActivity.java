package com.example.uts_pbp_b_kelompok_1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.uts_pbp_b_kelompok_1.Database.Database;
import com.example.uts_pbp_b_kelompok_1.Entity.TicketRoom;
import com.example.uts_pbp_b_kelompok_1.Model.User;
import com.example.uts_pbp_b_kelompok_1.Preferences.UserPreferences;
import com.example.uts_pbp_b_kelompok_1.databinding.ActivityOrderBinding;
import com.google.gson.Gson;

public class OrderActivity extends AppCompatActivity {

    private TicketRoom ticketRoom;
    private Event event;
    private ActivityOrderBinding binding;
    private Spinner spinnerSeat;
    private Spinner spinnerSection;
    private Spinner spinnerTime;
    private ImageButton btnBack;
    private Button btnPesan;
    UserPreferences userPreferences;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order);

        String strEvent = getIntent().getStringExtra("detailEvent");
        Gson gson = new Gson();
        event = gson.fromJson(strEvent, Event.class);

        binding.setEvent(event);

        spinnerSection = findViewById(R.id.spinnerSection);
        spinnerSeat = findViewById(R.id.spinnerSeatNumber);
        spinnerTime = findViewById(R.id.spinnerTime);

        userPreferences = new UserPreferences(this);
        user = userPreferences.getUserLogin();

        btnPesan = findViewById(R.id.btnPesan);
        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTicket();
                onBackPressed();
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

    public void addTicket(){
        final String eventName = event.getNamaEvent();
        final String eventDate = event.getTanggalEvent();
        final String eventVenue = event.getVenueEvent();
        final String eventAlamat = event.getAlamatEvent();
        final String seatSection= spinnerSection.getSelectedItem().toString();
        final String seatNumber = spinnerSeat.getSelectedItem().toString();
        final String eventTime = spinnerTime.getSelectedItem().toString();

        class AddTicket extends AsyncTask<Void, Void, Void>{

            @Override
            protected Void doInBackground(Void... voids) {
                TicketRoom ticketRoom = new TicketRoom();

                ticketRoom.setIdUser(user.getIduser());
                ticketRoom.setNamaPemilik(user.getFullName());
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
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                Toast.makeText(OrderActivity.this, "Berhasil Memesan Tiket", Toast.LENGTH_SHORT).show();
            }
        }
        AddTicket addTicket = new AddTicket();
        addTicket.execute();
    }
}
