package com.example.harshgupta.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showCustomToast(View v)
    {
        Toast toast=new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM,0,0);

        LayoutInflater inflater=getLayoutInflater();
        View appear=inflater.inflate(R.layout.toast_layout,(ViewGroup)findViewById(R.id.root));
        toast.setView(appear);
        toast.show();
    }
}
