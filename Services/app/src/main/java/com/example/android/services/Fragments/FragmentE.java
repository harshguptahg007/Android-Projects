package com.example.android.services.Fragments;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.services.MyService;
import com.example.android.services.R;
import com.example.android.services.adapters.FragmentsAdapter;

import java.util.ArrayList;

public class FragmentE extends Fragment {

    MyService tableService;
    boolean isBind = false;

    ArrayList<Integer> numbers = new ArrayList<Integer>();

    FragmentsAdapter fragmentsAdapter;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_e,container,false);

        Intent intent = new Intent(getActivity(),MyService.class);
        getActivity().bindService(intent,Mconnection, Context.BIND_AUTO_CREATE);

        recyclerView = view.findViewById(R.id.tableRecyclerView);

        return view;

    }

    public void getResult()
    {
        fragmentsAdapter = new FragmentsAdapter(getActivity(),numbers);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                recyclerView.getContext(),linearLayoutManager.getOrientation());

        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(fragmentsAdapter);

        recyclerView.setLayoutManager(linearLayoutManager);

    }



    private ServiceConnection Mconnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            MyService.LocalService localService = (MyService.LocalService) service;

            tableService = localService.getService();
            numbers = tableService.getTableResult();

            getResult();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBind = false;
        }
    };

    @Override
    public void onStop() {
        super.onStop();
        if (isBind)
        {
            getActivity().unbindService(Mconnection);
        }
    }
}
