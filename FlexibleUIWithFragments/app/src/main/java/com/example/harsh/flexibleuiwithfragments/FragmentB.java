package com.example.harsh.flexibleuiwithfragments;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {

    TextView myText;
    String mData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.my_fragment_b,container,false);

        if(savedInstanceState==null)//when the fragment is created for the first time
        {
            mData="";
        }
        else
        {
            mData=savedInstanceState.getString("text");
            TextView mTextView=view.findViewById(R.id.textView);
            mTextView.setText(mData);
        }

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myText=(TextView)getActivity().findViewById(R.id.textView);
    }

    public void changeData(int i)
    {
        Resources res=getResources();
        String []descriptions=res.getStringArray(R.array.descriptions);
        myText.setText(descriptions[i]);
        mData=descriptions[i];
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text",mData);
    }
}
