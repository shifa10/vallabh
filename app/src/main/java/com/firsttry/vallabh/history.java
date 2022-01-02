package com.firsttry.vallabh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.firsttry.vallabh.adepter.orederadepter;

import com.firsttry.vallabh.databinding.ActivityHistoryBinding;

import java.util.ArrayList;
import  com.firsttry.vallabh.model.oredermodel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class history extends AppCompatActivity {

    ActivityHistoryBinding binding;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        binding=ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        maindbhelper helper=new maindbhelper(this);
        ArrayList<oredermodel>list=helper.getoredrs();

        orederadepter adepter=new orederadepter(list,this);
        binding.historyRecycler.setAdapter(adepter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.historyRecycler.setLayoutManager(layoutManager);

        binding.bootomNavigation2.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id==R.id.history)
                {
                    Intent intent=new Intent(getApplicationContext(),history.class);
                    startActivity(intent);
                }
                else if(id==R.id.aboutus)
                {
                    Intent intent=new Intent(getApplicationContext(),aboutus.class);
                    startActivity(intent);
                }
                else if(id==R.id.home)
                {
                    Intent intent=new Intent(getApplicationContext(),foodsearchpage.class);
                    startActivity(intent);
                }

                return true;

            }


        });

        ;

    }
}