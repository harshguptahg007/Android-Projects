package com.example.android.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private List<News> newsList;
    private CustomItemClickListener listener;

    public CustomAdapter(Context context, List<News> newsList,CustomItemClickListener listener) {
        this.context = context;
        this.newsList = newsList;
        this.listener = listener;
    }


//    public CustomAdapter(Context context, List<News> newsList) {
//        this.context = context;
//        this.newsList = newsList;
//    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.custom_row,parent,false);

        final MyViewHolder viewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v,viewHolder.getPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        News news = newsList.get(position);

        holder.title.setText(news.getTitle());
        holder.description.setText(news.getDescription());

        Glide.with(context).load(news.getUrlImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title,description;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.heading);
            description = itemView.findViewById(R.id.description);
        }
    }

    public void clear() {
        final int size = newsList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                newsList.remove(0);
            }

            notifyItemRangeRemoved(0, size);
        }
    }
}
