package com.example.harshgupta.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler=new Handler();
        Runnable run=new Runnable() {
            @Override
            public void run() {

                //Insert code to be run every second

                handler.postDelayed(this,1000);
                Log.i("Handler is running","One second has passed");
                //here 'this' refers to the run method
                //in this method the code runs after every second with the help of handler
            }
        };
        handler.post(run);//initialise the runnable code...this line starts the execution of runnable code from the start.

        new CountDownTimer(10000,1000){

            public void onTick(long millisecondsUntilDone){

                //CountDown is counting down
                Log.i("DownTimer is running","One second has passed");
            }

            public void onFinish(){

                //Counter is finished.
                Log.i("Done!","CountDownTimer finished!");
            }
        }.start();
    }
}
