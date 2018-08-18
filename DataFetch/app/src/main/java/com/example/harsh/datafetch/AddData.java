package com.example.harsh.datafetch;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddData extends Fragment {


    public AddData() {
        // Required empty public constructor
    }

    private List<PredictionsSample> studentSample=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_data, container, false);

        InputStream in=getResources().openRawResource(R.raw.predictions);
        BufferedReader reader=new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));

        String line="";


        try {
            //Step Over headers
            reader.readLine();

            while ((line=reader.readLine())!=null){
                //Split by ','
                String []tokens=line.split(",");

                //Read the data
                PredictionsSample singleLine=new PredictionsSample();

                Predictions prediction=new Predictions();

                singleLine.setName(tokens[0]);
                String nme=tokens[0];
                prediction.setName(nme);

                singleLine.setRollNo(Integer.parseInt(tokens[1]));
                int roll=Integer.parseInt(tokens[1]);
                prediction.setRollNo(roll);

                singleLine.setBranch(tokens[2]);
                String bran=tokens[2];
                prediction.setBranch(bran);

                singleLine.setPredicted_marks(Double.parseDouble(tokens[3]));
                double marks=Double.parseDouble(tokens[3]);
                prediction.setPredicted_marks(marks);

                singleLine.setPredicted_drop(Double.parseDouble(tokens[4]));
                double drop=Double.parseDouble(tokens[4]);
                prediction.setPredicted_drop(drop);

                singleLine.setPersonality(tokens[5]);
                String person=tokens[5];
                prediction.setPersonality(person);

                singleLine.setRecommended1(tokens[6]);
                String recomm1=tokens[6];
                prediction.setRecommended1(recomm1);

                singleLine.setRecommended2(tokens[7]);
                String recomm2=tokens[7];
                prediction.setRecommended2(recomm2);

                singleLine.setRecommended3(tokens[8]);
                String recomm3=tokens[8];
                prediction.setRecommended3(recomm3);

                singleLine.setRecommended4(tokens[9]);
                String recomm4=tokens[9];
                prediction.setRecommended3(recomm4);

                singleLine.setRecommended5(tokens[10]);
                String recomm5=tokens[10];
                prediction.setRecommended3(recomm5);

                studentSample.add(singleLine);
                Fetch.myAppDatabase.myDao().tableAdd(prediction);

                Log.d("MyActivity","Just Added : "+singleLine);

            }
        } catch (IOException e) {
            Log.i("MyActivity","Error reading data file on line "+line ,e);
        }

        return view;
    }

    private void readStudentData() {



    }

}
