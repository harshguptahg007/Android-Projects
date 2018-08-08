package com.example.android.retrofitexample3.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.retrofitexample3.R;
import com.example.android.retrofitexample3.model.RetroPhoto;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<RetroPhoto> data;

    public RecyclerAdapter(Context context,ArrayList<RetroPhoto> data)
    {
        //getting the reference and the data from other class when the object of
        // RecyclerAdapter is created
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        //inflating the layout for particular row
        View view = LayoutInflater.from(context).
                inflate(R.layout.row_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        //binding the data with each row

        holder.textView.setText(data.get(position).getTitle());

        //TODO : set image for each row
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(data.get(position).getThumbnailUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
