package com.example.android.flexibleuiwithfragments2;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {

    TextView myText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.my_fragment_b,container,false);

        myText=(TextView)view.findViewById(R.id.textView);

        return view;
    }

    public void changeData(int index)
    {
        String []descriptions=getResources().getStringArray(R.array.description);
        myText.setText(descriptions[index]);
    }

}
