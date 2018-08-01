package com.example.android.fragmentbackstack;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener{

    FragmentManager manager;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager=getFragmentManager();
        text=(TextView)findViewById(R.id.message);
        manager.addOnBackStackChangedListener(this);
    }

    public void addA(View v)
    {
        FragmentA  f1=new FragmentA();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.group,f1,"A");
        transaction.addToBackStack("addA");//this line saves the transaction in the back stack
        transaction.commit();
    }

    public void addB(View v)
    {
        FragmentB  f2=new FragmentB();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.group,f2,"B");
        transaction.addToBackStack("addB");
        transaction.commit();
    }

    public void removeA(View v)
    {
        FragmentA f1= (FragmentA) manager.findFragmentByTag("A");
        FragmentTransaction transaction=manager.beginTransaction();
        if(f1!=null)//to check that fragment is there or not. f1 is null when user clicks the remove A button before adding A
        {
            transaction.remove(f1);
            transaction.addToBackStack("removeA");
            transaction.commit();
        }
        else
        {
            Toast.makeText(this,"The Fragment A was not added before",Toast.LENGTH_SHORT).show();
        }
    }

    public void removeB(View v)
    {
        FragmentB f2= (FragmentB) manager.findFragmentByTag("B");
        FragmentTransaction transaction=manager.beginTransaction();
        if(f2!=null)//to check that fragment is there or not. f1 is null when user clicks the remove A button before adding A
        {
            transaction.remove(f2);
            transaction.addToBackStack("removeB");
            transaction.commit();
        }
        else
        {
            Toast.makeText(this,"The Fragment B was not added before",Toast.LENGTH_SHORT).show();
        }
    }

    public void replaceWithB(View v)
    {
        FragmentB f2=new FragmentB();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.group,f2,"B");
        transaction.addToBackStack("replaceWithB");
        transaction.commit();
    }

    public void replaceWithA(View v)
    {
        FragmentA f1=new FragmentA();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.group,f1,"A");
        transaction.addToBackStack("replaceWithA");
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
            transaction.addToBackStack("attachA");
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
            transaction.addToBackStack("detachA");
            transaction.commit();
        }
    }

    public void back(View v)
    {
        manager.popBackStack();//this will pop the top most item from the back stack
    }

    public void popAddB(View v)
    {
        manager.popBackStack("addB",FragmentManager.POP_BACK_STACK_INCLUSIVE);
        //with flag as '0', addB becomes the topmost transaction in the back stack when this line executes.
        //when we say inclusive flag, this will remove the addB transaction as well and the previous transaction than addB
        // becomes the topmost item on the back stack.
    }

    @Override
    public void onBackStackChanged() {//this method gets called everytime whenever there is a change in the backstack
        text.setText(text.getText()+"\n");
        text.setText(text.getText()+"The current status of Back Stack"+"\n");

        int count=manager.getBackStackEntryCount();
        for (int i=count-1;i>=0;i--)
        {
            FragmentManager.BackStackEntry entry=manager.getBackStackEntryAt(i);
            //this entry will the string that was added in the back stack while calling transaction.addToBackStack for each transaction
            text.setText(text.getText()+" "+entry.getName()+" \n");
        }
        text.setText(text.getText()+"\n");
    }
}
