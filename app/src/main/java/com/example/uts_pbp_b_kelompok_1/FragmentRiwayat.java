package com.example.uts_pbp_b_kelompok_1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_pbp_b_kelompok_1.Adapter.RiwayatAdapter;
import com.example.uts_pbp_b_kelompok_1.Database.Database;
import com.example.uts_pbp_b_kelompok_1.Entity.TicketRoom;
import com.example.uts_pbp_b_kelompok_1.Preferences.UserPreferences;

import java.util.ArrayList;
import java.util.List;

public class FragmentRiwayat extends Fragment{

    private RecyclerView rvRiwayat;
    private UserPreferences userPreferences;
    private List<TicketRoom> ticketList;
    private RiwayatAdapter riwayatAdapter;

    public FragmentRiwayat() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_riwayat, container, false);

        rvRiwayat = root.findViewById(R.id.rvRiwayat);
        userPreferences = new UserPreferences(getContext());
        rvRiwayat.setLayoutManager(new LinearLayoutManager(getContext()));
        getTickets();
        ticketList = new ArrayList<>();

        return root;
    }

    //    Get Data Tiket yang sudah dipesan oleh User
    private void getTickets()
    {
        class GetTickets extends AsyncTask<Void, Void, List<TicketRoom>>
        {
            @Override
            protected List<TicketRoom> doInBackground(Void... voids) {
                List<TicketRoom> ticketList = Database.getInstance(getContext())
                        .getDatabase()
                        .ticketDao()
                        .getTicketsByUserId(userPreferences.getUserLogin().getIduser());
                return ticketList;
            }

            @Override
            protected void onPostExecute(List<TicketRoom> tickets) {
                super.onPostExecute(tickets);
                if(tickets.size() > 0) {
                    riwayatAdapter = new RiwayatAdapter(tickets, getContext());
                    rvRiwayat.setAdapter(riwayatAdapter);
                }
                else
                {
                    Fragment frag = new FragmentRiwayatKosong();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.layout_fragment, frag);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.addToBackStack(null);
                    ft.commit();
                }
            }
        }

        GetTickets getTickets = new GetTickets();
        getTickets.execute();
    }
}