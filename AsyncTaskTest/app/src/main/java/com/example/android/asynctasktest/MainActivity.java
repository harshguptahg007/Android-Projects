package com.example.android.asynctasktest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mainList;
    String []texts={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
            "19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36",
            "37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54",
            "55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72",
            "73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90",
            "91","92","93","94","95","96","97","98","99","100",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        //your activity has an inbuilt progress bar at the top right where your title is placed.
        //we enable that progress bar by the above line. This line must be typed above setContentView
        setContentView(R.layout.activity_main);

        mainList=findViewById(R.id.listView1);
        mainList.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>()));
        new MyTask().execute();
        //since you have not taken any argument in the doInBackground method then an empty execute method will be able to run
    }

    class MyTask extends AsyncTask<Void,String,Void>
    {

        private ArrayAdapter<String> adapter;
        private int count=0;

        @Override
        protected void onPreExecute()
        {
            adapter= (ArrayAdapter<String>) mainList.getAdapter();
            setProgressBarIndeterminate(false);//indeterminate because we have a definite number of items
            setProgressBarVisibility(true);
            //runs on Main Thread
        }

        @Override
        protected Void doInBackground(Void... params)//here Void corresponds to the 1st parameter of the AsyncTask class
        {
            for(String item:texts)
            {
                publishProgress(item);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
            //runs on background thread
        }

        @Override
        protected void onProgressUpdate(String... values)//Here String argument corresponds to the 2nd parameter of the AsyncTask class
        {
            //the function signature expects many arguments but we pass it only argument so it is at 1st position in values array
            //String... means a String array
            adapter.add(values[0]);
            count++;
            setProgress((int) (((double)count/texts.length)*10000));
            //runs on Main Thread
        }

        @Override
        protected void onPostExecute(Void aVoid)//Here Void argument corresponds to the 3rd parameter of the AsyncTask class
        {
            setProgressBarVisibility(false);
            L.s(MainActivity.this,"All items were added successfully");
            //runs on Main Thread
        }
    }
}
