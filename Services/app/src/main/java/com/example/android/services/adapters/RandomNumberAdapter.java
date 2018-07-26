package com.example.android.services.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.services.CustomItemClickListener;
import com.example.android.services.R;
import java.util.ArrayList;

public class RandomNumberAdapter extends RecyclerView.Adapter<RandomNumberAdapter.NumberHolder> {

    ArrayList<Integer> numbers;
    Context context;

    CustomItemClickListener listener;

    public RandomNumberAdapter(Context context, ArrayList<Integer> numbers,CustomItemClickListener listener){

        this.context = context;
        this.numbers = numbers;
        this.listener = listener;
    }

    @Override
    public NumberHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View myView = LayoutInflater.from(context).inflate(R.layout.row_number,parent,false);

        final NumberHolder numberHolder = new NumberHolder(myView);

        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v,numberHolder.getAdapterPosition());
            }
        });

        return numberHolder;

    }

    @Override
    public void onBindViewHolder(NumberHolder holder, final int position) {

        final int number = numbers.get(position);
        holder.numberText.setText(number+"");

    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    public class NumberHolder extends RecyclerView.ViewHolder
    {

        TextView numberText;

        public NumberHolder(View itemView) {
            super(itemView);
            numberText = itemView.findViewById(R.id.numberText);

        }
    }
}
