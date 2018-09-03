package com.example.harsh.roomexample;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        myAppDatabase= Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"user.db").allowMainThreadQueries() .build();

        if(findViewById(R.id.fragment_container)!=null){

            if(savedInstanceState!=null){
                return;
            }

            fragmentManager.beginTransaction().add(R.id.fragment_container,new HomeFragment()).commit();
        }
    }
}
