package com.example.android.alertdialogbox2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View view)
    {
        MyAlert myAlert=new MyAlert();
        myAlert.show(getFragmentManager(),"MyAlert");
        //we give a string name in the parameter to later refer to this fragment using findFragmentByTag.
    }
}
