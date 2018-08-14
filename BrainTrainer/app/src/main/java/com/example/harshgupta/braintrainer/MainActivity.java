package com.example.harshgupta.braintrainer;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    ArrayList<Integer> answers=new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    TextView resultText;
    int score=0;
    int numberOfQuestions=0;
    TextView pointsText;
    Button option1;
    Button option2;
    Button option3;
    Button option4;
    TextView sumText;
    TextView timerText;
    Button playAgainButton;
    RelativeLayout layout;

    public void playAgain(View view){

        score=0;
        numberOfQuestions=0;

        timerText.setText("30s");
        pointsText.setText("0/0");
        resultText.setText("");
        playAgainButton.setVisibility(View.INVISIBLE);
        layout.setVisibility(View.VISIBLE);

        generateQuestions();

        new CountDownTimer(30100,1000){

            public void onTick(long millisecondsUntilDone){

                timerText.setText(String.valueOf(millisecondsUntilDone/1000)+"s");

            }

            public void onFinish(){

                layout.setVisibility(View.INVISIBLE);
                playAgainButton.setVisibility(View.VISIBLE);
                timerText.setText("0s");
                resultText.setText("Your Score :"+Integer.toString(score)+" / "+Integer.toString(numberOfQuestions));
            }
        }.start();

    }

    public void generateQuestions(){

        Random rand=new Random();

        int a=rand.nextInt(21);//to generate random numbers between 0 and 20
        int b=rand.nextInt(21);//to generate random numbers between 0 and 20

        sumText.setText(Integer.toString(a)+" + "+Integer.toString(b));
        locationOfCorrectAnswer=rand.nextInt(4);

        answers.clear();//the answers that are generate in each questions needs to be cleared so we are clearing them here

        int incorrectAnswer;

        for(int i=0;i<4;i++){

            if(locationOfCorrectAnswer==i){
                answers.add(a+b);
            }
            else
            {
                incorrectAnswer=rand.nextInt(41);

                while(incorrectAnswer==a+b){
                    incorrectAnswer=rand.nextInt(41);
                }
                answers.add(incorrectAnswer);
            }
        }

        option1.setText(Integer.toString(answers.get(0)));
        option2.setText(Integer.toString(answers.get(1)));
        option3.setText(Integer.toString(answers.get(2)));
        option4.setText(Integer.toString(answers.get(3)));
    }

    public void start(View view){

        startButton.setVisibility(View.INVISIBLE);
        layout.setVisibility(RelativeLayout.VISIBLE);

        playAgain(findViewById(R.id.playAgainButton));//it doesn't matter which view we will pass here...it just wants a view
        //the playAgain method is in start method bcoz we want to start the timer when the start button is clicked
    }

    public void chooseAnswer(View view){

        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            resultText.setText("Correct!");
            score++;
        }
        else
            resultText.setText("Wrong!");
        numberOfQuestions++;
        pointsText.setText(Integer.toString(score)+" / "+Integer.toString(numberOfQuestions));
        generateQuestions();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton=(Button)findViewById(R.id.startbutton);
        sumText=(TextView)findViewById(R.id.sumTextView);
        option1=(Button)findViewById(R.id.option1);
        option2=(Button)findViewById(R.id.option2);
        option3=(Button)findViewById(R.id.option3);
        option4=(Button)findViewById(R.id.option4);
        resultText=(TextView)findViewById(R.id.resultTextView);
        pointsText=(TextView)findViewById(R.id.pointsTextView);
        timerText=(TextView)findViewById(R.id.timerTextView);
        playAgainButton=(Button)findViewById(R.id.playAgainButton);
        layout=(RelativeLayout)findViewById(R.id.relativeLayout);


    }
}
