package com.example.uts_pbp_b_kelompok_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentDetailTicket extends Fragment {

    private static final String bund_namaEvent = "namaEvent";
    private static final String bund_namaPemilik = "namaPemilik";
    private static final String bund_kodeBooking = "kodeBooking";
    private static final String bund_section = "section";
    private static final String bund_seatNumber = "seatNumber";
    private static final String bund_tanggal = "tanggal";
    private static final String bund_venue = "venue";

    public FragmentDetailTicket() {
        // Required empty public constructor
    }

    public static FragmentDetailTicket newInstance(int kodeBooking, String namaEvent,
                                                   String namaPemilik, String section, String seatNumber,
                                                   String tanggal, String venue) {
        Bundle bundle = new Bundle();
        // Save data here
        bundle.putInt(bund_kodeBooking, kodeBooking);
        bundle.putString(bund_namaEvent, namaEvent);
        bundle.putString(bund_namaPemilik, namaPemilik);
        bundle.putString(bund_section, section);
        bundle.putString(bund_seatNumber, seatNumber);
        bundle.putString(bund_tanggal, tanggal);
        bundle.putString(bund_venue, venue);
        FragmentDetailTicket fragment = new FragmentDetailTicket();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        int kodeBooking = getArguments().getInt(bund_kodeBooking);
        String namaEvent = getArguments().getString(bund_namaEvent);
        String namaPemilik = getArguments().getString(bund_namaPemilik);
        String section = getArguments().getString(bund_section);
        String seatNumber = getArguments().getString(bund_seatNumber);
        String tanggal = getArguments().getString(bund_tanggal);
        String venue = getArguments().getString(bund_venue);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_ticket, container, false);
    }
}