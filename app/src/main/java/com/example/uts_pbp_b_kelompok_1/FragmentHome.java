package com.example.uts_pbp_b_kelompok_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.uts_pbp_b_kelompok_1.Adapter.EventAdapter;
import com.example.uts_pbp_b_kelompok_1.DetailEventActivity;
import com.example.uts_pbp_b_kelompok_1.DummyEvent;
import com.example.uts_pbp_b_kelompok_1.Event;
import com.example.uts_pbp_b_kelompok_1.MainActivity;
import com.example.uts_pbp_b_kelompok_1.R;
import com.example.uts_pbp_b_kelompok_1.databinding.FragmentHomeBinding;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    ArrayList<Event> listEvent;
    FragmentHomeBinding binding;

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listEvent = new DummyEvent().dataEvent;

        EventAdapter adapter = new EventAdapter(getContext(), listEvent);
        binding.rvEvent.setLayoutManager(new LinearLayoutManager((Activity) this.getContext()));
        binding.rvEvent.setAdapter(adapter);
    }
}









