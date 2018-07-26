package com.example.android.services;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.services.Fragments.FragmentA;
import com.example.android.services.Fragments.FragmentB;

public class MainActivity extends AppCompatActivity {

    static FragmentManager manager;
    static int data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager=getFragmentManager();

        addMainFragment();

        //replaceAWithB();
    }

    private void addMainFragment() {

        FragmentA fragmentA = new FragmentA();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.group,fragmentA,"MainFragment");
        transaction.commit();

    }

    public static void replaceAWithB(){

        data = FragmentA.itemClicked;
        //Log.i("VIVZ",a+"");

        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.group,fragmentB,"Fragment B");
        transaction.commit();

    }
}
