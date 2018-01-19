package com.example.harsh.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view){

        EditText edittext=(EditText)findViewById(R.id.money);
        double m=Double.parseDouble(edittext.getText().toString())*63.86;
        String s=String.valueOf(m);
        Toast.makeText(this,(s)+" in Indian Rupees",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
