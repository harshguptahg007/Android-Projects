package com.example.android.externalstoragetest;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Second extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText=findViewById(R.id.userNameData);
    }

    private String readData(File myFile)
    {
        FileInputStream fileInputStream=null;
        try {
            fileInputStream=new FileInputStream(myFile);
            //FileInputStream is responsible for reading the file from the memory.
            int read=-1;//if nothing is read then the fileInpurStream object gives '-1'

            //fileInputStream.read returns the ASCII codes of the text it reads
            //'-1' is returned when you reach end of the file

            StringBuffer buffer=new StringBuffer();
            while((read=fileInputStream.read())!=-1)
            {
                buffer=buffer.append((char)read);
            }
            return buffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream!=null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void loadInternalCache(View view)
    {
        File folder=getCacheDir();//getting reference to the file on the system
        File myFile=new File(folder,"mydata1.txt");
        String data=readData(myFile);

        if(data!=null)
        {
            editText.setText(data);
        }
        else
        {
            editText.setText("No data was returned");
        }
    }

    public void loadExternalCache(View view)
    {
        File folder=getExternalCacheDir();//getting reference to the file on the system
        File myFile=new File(folder,"mydata2.txt");
        String data=readData(myFile);

        if(data!=null)
        {
            editText.setText(data);
        }
        else
        {
            editText.setText("No data was returned");
        }
    }

    public void loadPrivateExternalFile(View view)
    {
        File folder=getExternalFilesDir("Slidenerd");//getting reference to the file on the system
        File myFile=new File(folder,"mydata3.txt");
        String data=readData(myFile);

        if(data!=null)
        {
            editText.setText(data);
        }
        else
        {
            editText.setText("No data was returned");
        }
    }

    public void loadPublicExternalFile(View view)
    {
        File folder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);//getting reference to the file on the system
        File myFile=new File(folder,"mydata4.txt");
        String data=readData(myFile);

        if(data!=null)
        {
            editText.setText(data);
        }
        else
        {
            editText.setText("No data was returned");
        }
    }

    public void previous(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void message(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
