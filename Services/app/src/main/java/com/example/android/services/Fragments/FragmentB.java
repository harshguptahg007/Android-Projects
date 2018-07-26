package com.example.android.services.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.services.R;

public class FragmentB extends Fragment {

    FragmentManager manager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_b,container,false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            manager = getChildFragmentManager();
        }

        FragmentTransaction transaction = manager.beginTransaction();

        FragmentC fragmentC = new FragmentC();
        FragmentD fragmentD = new FragmentD();
        FragmentE fragmentE = new FragmentE();

        transaction.add(R.id.fragmentB,fragmentC,"Fragment C");
        transaction.add(R.id.fragmentB,fragmentD,"Fragment D");
        transaction.add(R.id.fragmentB,fragmentE,"Fragment E");

        transaction.commit();

        return view;

    }


}
