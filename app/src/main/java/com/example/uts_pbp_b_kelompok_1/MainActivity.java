package com.example.uts_pbp_b_kelompok_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if(item.getItemId() == R.id.menuHome){
//                changeFragment(new HomeFragment());
            }
            else if(item.getItemId() == R.id.menuTransaksi){
//                changeFragment(new TodoListFragment());
            }
            else if(item.getItemId() == R.id.menuRiwayat){
//                changeFragment(new TodoListFragment());
            }
            else if(item.getItemId() == R.id.menuProfile){
//                changeFragment(new TodoListFragment());
            }
            return true;
        }
    };

    //  Method untuk mengubah fragment
    public void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_fragment, fragment)
                .commit();
    }
}