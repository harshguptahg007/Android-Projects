package com.example.harshgupta.csvdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readStudentData();
    }

    private List<StudentSample> studentSample=new ArrayList<>();
    private void readStudentData() {

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
                StudentSample singleLine=new StudentSample();
                singleLine.setName(tokens[0]);
                singleLine.setRollNo(Integer.parseInt(tokens[1]));
                singleLine.setBranch(tokens[2]);
                singleLine.setPredicted_marks(Double.parseDouble(tokens[3]));
                singleLine.setPredicted_drop(Double.parseDouble(tokens[4]));
                singleLine.setPersonality(tokens[5]);
                singleLine.setRecommended1(tokens[6]);
                singleLine.setRecommended2(tokens[7]);
                singleLine.setRecommended3(tokens[8]);
                singleLine.setRecommended4(tokens[9]);
                singleLine.setRecommended5(tokens[10]);

                studentSample.add(singleLine);

                Log.d("MyActivity","Just Added : "+singleLine);

            }
        } catch (IOException e) {
            Log.i("MyActivity","Error reading data file on line "+line ,e);
        }

    }
}
