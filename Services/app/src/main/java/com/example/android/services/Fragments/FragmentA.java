package com.example.android.services.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.services.CustomItemClickListener;
import com.example.android.services.MainActivity;
import com.example.android.services.R;
import com.example.android.services.adapters.RandomNumberAdapter;

import java.util.ArrayList;
import java.util.Random;

public class FragmentA extends Fragment {

    public static ArrayList<Integer> numbers = new ArrayList<Integer>();
    RandomNumberAdapter randomNumberAdapter;
    public static int itemClicked;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        populateData();

        View view = inflater.inflate(R.layout.fragment_a,container,false);

        RecyclerView recyclerView = view.findViewById(R.id.randomNumberRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                recyclerView.getContext(),linearLayoutManager.getOrientation());

        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.setLayoutManager(linearLayoutManager);

        randomNumberAdapter = new RandomNumberAdapter(getActivity(), numbers, new CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                itemClicked = numbers.get(position);
                //Log.i("VIVZ",itemClicked+"");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                MainActivity.replaceAWithB();
            }
        });

        recyclerView.setAdapter(randomNumberAdapter);
        return view;

    }

    private void populateData(){

        //Log.i("Vibz","dffbn");
        Random random = new Random();

        for (int i=0;i<10;i++){

            int r=random.nextInt(100);
            //Log.i("VIVZ",r+"");
            numbers.add(r);

        }

    }
}
