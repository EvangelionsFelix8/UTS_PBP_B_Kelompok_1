package com.example.uts_pbp_b_kelompok_1.Fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uts_pbp_b_kelompok_1.Adapter.EventAdapter;
import com.example.uts_pbp_b_kelompok_1.DummyEvent;
import com.example.uts_pbp_b_kelompok_1.Event;
import com.example.uts_pbp_b_kelompok_1.R;
import com.example.uts_pbp_b_kelompok_1.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    ArrayList<Event> listEvent;
    FragmentHomeBinding binding;

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding = DataBindingUtil.setContentView((Activity) this.getContext(), R.layout.fragment_home);
        listEvent = new DummyEvent().dataEvent;

        EventAdapter adapter = new EventAdapter(listEvent);
        binding.rvEvent.setLayoutManager(new LinearLayoutManager((Activity) this.getContext()));
        binding.rvEvent.setAdapter(adapter);
    }
}









