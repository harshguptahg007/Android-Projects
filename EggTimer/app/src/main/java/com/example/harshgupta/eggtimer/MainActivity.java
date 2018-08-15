package com.example.harshgupta.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar timerSeek;
    Button controllerButton;
    TextView timerTextView;
    CountDownTimer countDownTimer;
    boolean counterIsActive=false;

    public void resetTimer(){
        countDownTimer.cancel();
        controllerButton.setText("Go!");
        timerSeek.setProgress(30);
        timerTextView.setText("0:30");
        timerSeek.setEnabled(true);
        counterIsActive=false;
    }

    public void updateTimer(int secondsLeft){

        int minutes=(int)secondsLeft/60;
        int seconds=secondsLeft-minutes*60;

        String secondString=Integer.toString(seconds);
        if(seconds<=9)
        {
            secondString="0"+secondString;
        }

        timerTextView.setText(Integer.toString(minutes)+":"+secondString);


    }
    public void controlTimer(View view){

        if(counterIsActive==false) {
            counterIsActive = true;
            timerSeek.setEnabled(false);//to disable seekbar when timer is active
            controllerButton.setText("Stop");

            countDownTimer=new CountDownTimer(timerSeek.getProgress() * 1000 + 100, 1000) {

                public void onTick(long millisUntilFinished) {

                    updateTimer((int) millisUntilFinished / 1000);
                }

                public void onFinish() {

                    resetTimer();
                    MediaPlayer mplayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    mplayer.start();
                }
            }.start();
        }
        else{
            resetTimer();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeek=(SeekBar)findViewById(R.id.timerSeekBar);
        timerSeek.setMax(600);
        timerSeek.setProgress(30);

        timerTextView=(TextView)findViewById(R.id.timerTextView);
        controllerButton=(Button)findViewById(R.id.controller);

        timerSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
