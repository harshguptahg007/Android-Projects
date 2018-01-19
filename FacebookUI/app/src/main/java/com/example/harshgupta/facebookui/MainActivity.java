package com.example.harshgupta.facebookui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSomething(View v)
    {
        Toast toast=null;
        if(v.getId()==R.id.button1)
        {
            toast=Toast.makeText(this,"Successful Login",Toast.LENGTH_SHORT);
        }
        if(v.getId()==R.id.button2)
        {
            toast=Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}
