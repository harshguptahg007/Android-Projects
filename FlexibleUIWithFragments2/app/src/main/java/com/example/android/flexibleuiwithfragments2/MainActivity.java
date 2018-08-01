package com.example.android.flexibleuiwithfragments2;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentA.Communicator {

    FragmentA f1;
    FragmentB f2;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager=getFragmentManager();
        f1= (FragmentA) manager.findFragmentById(R.id.fragment1);
        f1.setCommunicator(this);
    }

    @Override
    public void respond(int index) {
        f2= (FragmentB) manager.findFragmentById(R.id.fragment2);
        if(f2!=null && f2.isVisible())//if this condition is true then we are in our landscape orientation
        {
            //we do not rely on f2 being null beacuse fragment has different states and it may not be null but in landscape mode f2 has to be
            //visible so  the second condition will always hold for the landscape orientation
            f2.changeData(index);
        }
        else//otherwise we are in portrait orientation
        {
            Intent intent=new Intent(this,AnotherActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);
        }
    }
}
