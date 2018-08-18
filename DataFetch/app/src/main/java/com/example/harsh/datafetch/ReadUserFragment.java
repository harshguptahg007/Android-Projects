package com.example.harsh.datafetch;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {

    private TextView textView;

    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_read_user, container, false);

        textView=view.findViewById(R.id.txt_display_info);

        List<Predictions> users=Fetch.myAppDatabase.myDao().getEntries();

        String info="";
        int i=1;

        for(Predictions usr:users){
            if(i>=10)
                break;

            String nme=usr.getName();
            int roll=usr.getRollNo();
            String bran=usr.getBranch();
            double marks=usr.getPredicted_marks();
            double drop=usr.getPredicted_drop();
            String person=usr.getPersonality();
            String recomm1=usr.getRecommended1();
            String recomm2=usr.getRecommended2();
            String recomm3=usr.getRecommended3();
            String recomm4=usr.getRecommended4();
            String recomm5=usr.getRecommended5();

            info=info+"\n\n"+"Name : "+nme+"\nRoll : "+roll+"\nBranch : "+bran+"\nPredicted Marks : "+marks+"\nPredicted Drop : "+drop
            +"\nPersonality : "+person+"\nRecommeded1 : "+recomm1+"\nRecommeded2 : "+recomm2+"\nRecommeded3 : "+recomm3
                    +"\nRecommeded4 : "+recomm4+"\nRecommeded5 : "+recomm5;
        }

        textView.setText(info);


        return view;
    }

}
