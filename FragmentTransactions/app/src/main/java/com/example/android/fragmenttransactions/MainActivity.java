package com.example.android.fragmenttransactions;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager=getFragmentManager();//this is the object through which you perform all the interactions with the fragments
    }

    public void addA(View v)
    {
        FragmentA f1=new FragmentA();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.group,f1,"A");//the 3rd fragment gets associated with the fragment as a Tag value. When you will refer
        // this tag value then the fragment associated with this tag value will be called.
        transaction.commit();
    }

    public void removeA(View v)
    {
        FragmentA f1= (FragmentA) manager.findFragmentByTag("A");
        FragmentTransaction transaction=manager.beginTransaction();
        if(f1!=null)//to check that fragment is there or not. f1 is null when user clicks the remove A button before adding A
        {
            transaction.remove(f1);
            transaction.commit();
        }
        else
        {
            Toast.makeText(this,"The Fragment A was not added before",Toast.LENGTH_SHORT).show();
        }
    }

    public void replaceAWithB(View v)
    {
        FragmentB f2=new FragmentB();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.group,f2,"B");
        transaction.commit();
    }

    public void addB(View v)
    {
        FragmentB f2=new FragmentB();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.group,f2,"B");
        transaction.commit();
    }

    public void removeB(View v)
    {
        FragmentB f2= (FragmentB) manager.findFragmentByTag("B");
        FragmentTransaction transaction=manager.beginTransaction();
        if(f2!=null)//to check that fragment is there or not. f1 is null when user clicks the remove A button before adding A
        {
            transaction.remove(f2);
            transaction.commit();
        }
        else
        {
            Toast.makeText(this,"The Fragment B was not added before",Toast.LENGTH_SHORT).show();
        }
    }

    public void replaceBWithA(View v)
    {
        FragmentA f1=new FragmentA();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.group,f1,"A");
        transaction.commit();
    }

    public void attachA(View v)
    {
        FragmentA f1= (FragmentA) manager.findFragmentByTag("A");
        FragmentTransaction transaction=manager.beginTransaction();
        if(f1!=null)
        {
            transaction.attach(f1);//here you have a fragment which you wanna make visible
            //to make that fragment invisible first you have to call detach
            transaction.commit();
        }
    }

    public void detachA(View v)
    {
        //detach function is called when you do not want to completely destroy the object i.e. you do not want to destroy
        //its linking with activity but just want to make that fragment invisible
        FragmentA f1= (FragmentA) manager.findFragmentByTag("A");
        FragmentTransaction transaction=manager.beginTransaction();
        if(f1!=null)
        {
            transaction.detach(f1);//making the fragment invisible
            transaction.commit();
        }
    }
}

