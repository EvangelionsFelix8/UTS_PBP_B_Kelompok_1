package com.example.uts_pbp_b_kelompok_1;

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
import android.widget.TextView;

import com.example.uts_pbp_b_kelompok_1.Adapter.EventAdapter;
import com.example.uts_pbp_b_kelompok_1.Model.User;
import com.example.uts_pbp_b_kelompok_1.Preferences.UserPreferences;
import com.example.uts_pbp_b_kelompok_1.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    private TextView tvUsername;
    private User user;
    private UserPreferences userPreferences;

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

        tvUsername = view.findViewById(R.id.tvUsername);
        userPreferences = new UserPreferences(this.getContext());
        user = userPreferences.getUserLogin();

        tvUsername.setText(user.getUsername());
        listEvent = new DummyEvent().dataEvent;

        EventAdapter adapter = new EventAdapter(getContext(), listEvent);
        binding.rvEvent.setLayoutManager(new LinearLayoutManager((Activity) this.getContext()));
        binding.rvEvent.setAdapter(adapter);
    }
}









