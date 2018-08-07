package com.example.android.viewpager;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    SliderAdapter(Context context){
        this.context = context;
        //constructor is used for the giving the reference of the context to this adapter
    }

    //Arrays
    public int[] slide_images = {
            R.drawable.eat_icon,
            R.drawable.sleep_icon,
            R.drawable.code_icon
    };

    public String[] slide_headings = {
            "EAT",
            "SLEEP",
            "CODE"
    };

    public String[] slide_descriptions = {
            " if you are familiar with PHP, you can read the original article here: S.O.L.I.D: The " +
                    "First 5 Principles of Object Oriented Design.",
            " if you are familiar with PHP, you can read the original article here: S.O.L.I.D: The " +
                    "First 5 Principles of Object Oriented Design.",
            " if you are familiar with PHP, you can read the original article here: S.O.L.I.D: The " +
                    "First 5 Principles of Object Oriented Design."
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view,Object object) {
        return view == (RelativeLayout)object;
    }

    @Override
    public Object instantiateItem( ViewGroup container, int position) {
        //this method is required to get those slide effects or inflate all things in the adapter
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = view.findViewById(R.id.imageView);
        TextView headings = view.findViewById(R.id.headingTextView);
        TextView descriptions = view.findViewById(R.id.descriptionTextView);

        slideImageView.setImageResource(slide_images[position]);
        headings.setText(slide_headings[position]);
        descriptions.setText(slide_descriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
        //once we reach the last page it will then stop prevent us from actually getting any error
        // or something, it will stop the viewpager right over there
        container.removeView((RelativeLayout)object);
    }
}
