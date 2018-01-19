package com.example.harsh.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int r;

    public void makeToast(String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
    public void clickFunction(View view){
        EditText edit=(EditText)findViewById(R.id.edittext);
        int m=Integer.parseInt(edit.getText().toString());
        if(m>r)
            makeToast("Lower!");
        else if(m<r)
        makeToast("Higher!");
        else {
            makeToast("That's right! Try again!");

            Random rand=new Random();
            r=rand.nextInt(20)+1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand=new Random();
        r=rand.nextInt(20)+1;
    }
}
