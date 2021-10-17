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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uts_pbp_b_kelompok_1.Adapter.EventAdapter;
import com.example.uts_pbp_b_kelompok_1.DetailEventActivity;
import com.example.uts_pbp_b_kelompok_1.DummyEvent;
import com.example.uts_pbp_b_kelompok_1.Event;
import com.example.uts_pbp_b_kelompok_1.MainActivity;
import com.example.uts_pbp_b_kelompok_1.Model.User;
import com.example.uts_pbp_b_kelompok_1.Preferences.UserPreferences;
import com.example.uts_pbp_b_kelompok_1.R;
import com.example.uts_pbp_b_kelompok_1.databinding.FragmentHomeBinding;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    private TextView tvUsername;
    private User user;
    private UserPreferences userPreferences;
    private Button btnLogout;

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

        btnLogout = view.findViewById(R.id.btnLogout);
        tvUsername = view.findViewById(R.id.tvUsername);
        userPreferences = new UserPreferences(this.getContext());
        user = userPreferences.getUserLogin();

        tvUsername.setText(user.getUsername());

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userPreferences.logout();
                Toast.makeText(getContext(), "Berhasil Logout", Toast.LENGTH_SHORT).show();
                checkLogin();
            }
        });
        listEvent = new DummyEvent().dataEvent;

        EventAdapter adapter = new EventAdapter(getContext(), listEvent);
        binding.rvEvent.setLayoutManager(new LinearLayoutManager((Activity) this.getContext()));
        binding.rvEvent.setAdapter(adapter);
    }

    private void checkLogin() {
        if (!userPreferences.checkLogin()) {
            startActivity(new Intent(getContext(), LoginActivity.class));
            getActivity().finish();
        } else {
            Toast.makeText(getContext(), "Heyy Kamu Sudah Login !!", Toast.LENGTH_SHORT).show();
        }
    }
}









