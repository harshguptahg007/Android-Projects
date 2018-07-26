package com.example.android.services.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.services.R;

import java.util.ArrayList;

public class FragmentsAdapter extends RecyclerView.Adapter<FragmentsAdapter.FragmentNumberHolder>{

    ArrayList<Integer> numbers;
    Context context;

    public FragmentsAdapter(Context context , ArrayList<Integer> numbers)
    {
        this.context = context;
        this.numbers = numbers;
    }

    @Override
    public FragmentNumberHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View myView = LayoutInflater.from(context).inflate(R.layout.row_fragment,parent,false);
        return new FragmentNumberHolder(myView);
    }

    @Override
    public void onBindViewHolder(FragmentNumberHolder holder, int position) {

        int number = numbers.get(position);
        holder.fragmentNumber.setText(number+"");

    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    public class FragmentNumberHolder extends RecyclerView.ViewHolder {

        TextView fragmentNumber;

        public FragmentNumberHolder(View itemView) {
            super(itemView);

            fragmentNumber = itemView.findViewById(R.id.fragmentNumber);
        }
    }
}
