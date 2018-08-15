package com.example.harsh.connect3;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //0 means yellow and 1 means red
    int activePlayer=0;
    boolean gameIsActive=true;

    //2 means not played
    int []gameState={2,2,2,2,2,2,2,2,2};

    int winningPositions[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropIn(View view){

        ImageView counter=(ImageView)view;//here we are interested in which image the user tapped on so we deal just with view

        int tapped=Integer.parseInt(counter.getTag().toString());

        if(gameState[tapped]==2 && gameIsActive)//this is used to stop the players from tapping the same view many times
        {

            gameState[tapped]=activePlayer;

            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;

            }
            else {

                counter.setImageResource(R.drawable.red);
                activePlayer = 0;

            }
            counter.animate().translationYBy(1000f).rotation(3600f).setDuration(1000);

            for(int win[]:winningPositions){
                if(gameState[win[0]]==gameState[win[1]] && gameState[win[1]]==gameState[win[2]]
                        && gameState[win[0]]!=2) {

                    //Someone has won

                    gameIsActive=false;
                    String won="Red";
                    if(gameState[win[0]]==0);
                    won="Yellow";

                    TextView winnerMessage=(TextView)findViewById(R.id.winner);
                    winnerMessage.setText(won+" has won!");
                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgain);
                    layout.setVisibility(View.VISIBLE);
                }
                else{
                    boolean gameIsOver=true;
                    for(int gameCounter : gameState){

                        if(gameCounter==2)
                            gameIsOver=false;
                    }

                    if(gameIsOver)
                    {
                        TextView winnerMessage=(TextView)findViewById(R.id.winner);
                        winnerMessage.setText("It's a draw");
                        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgain);
                        layout.setVisibility(View.VISIBLE);
                    }
                }
            }
        }

    }

    public void playAgain(View view)//here we are reseting everything
    {
        gameIsActive=true;

        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgain);
        layout.setVisibility(View.INVISIBLE);

        activePlayer=0;

        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }

        //here we are reseting the images on the screen.
        GridLayout grid=(GridLayout)findViewById(R.id.gridLayout);
        for(int i=0;i<grid.getChildCount();i++){
            ((ImageView)grid.getChildAt(i)).setImageResource(0);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
