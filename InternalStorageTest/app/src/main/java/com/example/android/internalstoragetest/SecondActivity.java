package com.example.android.internalstoragetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    EditText userName,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        userName=findViewById(R.id.username_editText);
        password=findViewById(R.id.password_editText);
    }

    public void load(View view)
    {
        //maybe the file you are searching is not there so we need to surround this operation with try catch
        try {
            FileInputStream fileInputStream=openFileInput("vivz.txt");
            //InputStream and OutputStream work with binary data so the data is stored in the form of ASCII code.
            //if the file becomes empty in the desired location then the read operation will give '-1'.
            int read=-1;
            StringBuffer buffer=new StringBuffer();//StringBuffer allows the string to be modified whereas string does not
            // allows modification of the data
            while((read=fileInputStream.read())!=-1)
            {
                buffer.append((char)read);
            }

            String text1=buffer.substring(0,buffer.indexOf(" "));
            String text2=buffer.substring(buffer.indexOf(" ")+1);

            userName.setText(text1);
            password.setText(text2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(userName.getText().toString().length()!=0 && password.getText().toString().length()!=0)
        Toast.makeText(this,"Load Successfull",Toast.LENGTH_SHORT).show();
    }

    public void previous(View view)
    {
        Toast.makeText(this,"Previous Called",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
