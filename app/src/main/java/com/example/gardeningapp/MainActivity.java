package com.example.gardeningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        BottomNavigationView bottomNavigationView = findViewById(R.id.btm);
       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()) {
                   case R.id.home:
                       Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.search:
                       Toast.makeText(getApplicationContext(), "search", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.forum:
                       Toast.makeText(getApplicationContext(), "Discuss Forum", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.add:
                       Toast.makeText(getApplicationContext(), "Add something", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.profile:
                       Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();
                       break;
               }
               return true;
           }
       });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.noti){
            Toast.makeText(getApplicationContext(),"Notifications",Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.chat){
            Toast.makeText(getApplicationContext(),"Send message",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}