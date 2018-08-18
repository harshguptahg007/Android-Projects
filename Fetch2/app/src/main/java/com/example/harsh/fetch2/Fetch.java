package com.example.harsh.fetch2;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Fetch extends AppCompatActivity implements View.OnClickListener {

    public static MyPredictionDatabase myAppDatabase;
    public static MyStudentsDatabase myStudentsDatabase;
    public static MyTeachersDatabase myTeachersDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);

        myAppDatabase= Room.databaseBuilder(getApplicationContext(),MyPredictionDatabase.class,"predictions.db").allowMainThreadQueries().build();
        myStudentsDatabase=Room.databaseBuilder(getApplicationContext(),MyStudentsDatabase.class,"students.db").allowMainThreadQueries().build();
        myTeachersDatabase=Room.databaseBuilder(getApplicationContext(),MyTeachersDatabase.class,"teachers.db").allowMainThreadQueries().build();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.addPredictionDetails:

                InputStream in=getResources().openRawResource(R.raw.predictions);
                BufferedReader reader=new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));

                String line="";

                try {
                    //Step Over headers
                    reader.readLine();

                    while ((line=reader.readLine())!=null){

                        //Split by ','
                        String []tokens=line.split(",");

                        BackgroundTask backgroundTask=new BackgroundTask(this);
                        backgroundTask.execute("addPredictionInfo",tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6],
                                tokens[7],tokens[8],tokens[9],tokens[10]);

                    }
                } catch (IOException e) {
                    Log.i("MyActivity","Error reading data file on line "+line ,e);
                }

                break;

            case R.id.addStudentsDetails :

                InputStream is=getResources().openRawResource(R.raw.clean_4);
                BufferedReader reader1=new BufferedReader(new InputStreamReader(is,Charset.forName("UTF-8")));

                String line2="";

                try {
                    //Step Over headers
                    reader1.readLine();

                    while ((line2=reader1.readLine())!=null){

                        //Split by ','
                        String [] tokens2 =line2.split(",");

                        BackgroundTask2 backgroundTask2=new BackgroundTask2(this);
                        backgroundTask2.execute("addStudentInfo", tokens2[0], tokens2[1], tokens2[2], tokens2[3], tokens2[4], tokens2[5], tokens2[6],
                                tokens2[7], tokens2[8], tokens2[9], tokens2[10], tokens2[11], tokens2[12], tokens2[13], tokens2[14], tokens2[15], tokens2[16],
                                tokens2[17], tokens2[18], tokens2[19], tokens2[20], tokens2[21], tokens2[22], tokens2[23], tokens2[24], tokens2[25],
                                tokens2[26]);
                    }
                } catch (IOException e) {
                    Log.i("MyActivity","Error reading data file on line "+line2 ,e);
                }

                break;

            case R.id.viewPredictionDetails :

                Intent viewDetailsIntent=new Intent(this,ViewPredictionsDetails.class);
                startActivity(viewDetailsIntent);

                break;

            case R.id.viewStudentDetails :

                Intent viewStudentDetailsIntent=new Intent(this,ViewStudentDetails.class);
                startActivity(viewStudentDetailsIntent);

                break;

            case R.id.studentLogin :

                Intent viewStudentLoginIntent=new Intent(this,LoginStudent.class);
                startActivity(viewStudentLoginIntent);

                break;

            case R.id.addTeacherDetails:

                InputStream te=getResources().openRawResource(R.raw.teachers);
                BufferedReader reader3=new BufferedReader(new InputStreamReader(te, Charset.forName("UTF-8")));

                String line3="";

                try {
                    //Step Over headers
                    reader3.readLine();

                    while ((line3=reader3.readLine())!=null){

                        //Split by ','
                        String []tokens=line3.split(",");

                        BackgroundTask3 backgroundTask3=new BackgroundTask3(this);
                        backgroundTask3.execute("addTeacherInfo",tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6]);

                    }
                } catch (IOException e) {
                    Log.i("MyActivity","Error reading data file on line "+line3 ,e);
                }

                break;

            case R.id.teacherLogin :

                Intent viewTeacherLoginIntent=new Intent(this,LoginTeacher.class);
                startActivity(viewTeacherLoginIntent);

                break;

        }

    }
}
