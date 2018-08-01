package com.example.android.externalstoragetest;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.userName);
    }

    private void writeData(File myFile, String data)
    {
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=new FileOutputStream(myFile);//we pass 'myFile' here because we want to write in it.
            fileOutputStream.write(data.getBytes());
            message(data+" was written successfully "+myFile.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fileOutputStream!=null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveInternalCache(View view)
    {
        String data=editText.getText().toString();
        File folder=getCacheDir();//getting reference of the cache directory on the app
        File myFile=new File(folder,"mydata1.txt");//this myFile object will refer to the
        // 'mydata1.txt' inside the 'folder' object
        writeData(myFile,data);
    }

    public void saveExternalCache(View view)
    {
        String data=editText.getText().toString();
        File folder=getExternalCacheDir();//getting reference of the external cache directory on the app
        File myFile=new File(folder,"mydata2.txt");//this myFile object will refer to the
        // 'mydata1.txt' inside the 'folder' object
        writeData(myFile,data);
    }

    public void savePrivateExternalFile(View view)
    {
        String data=editText.getText().toString();
        File folder=getExternalFilesDir("Slidenerd");//this will create a folder 'Slidenerd'
        // which will be private to the app
        File myFile=new File(folder,"mydata3.txt");//this myFile object will refer to the
        // 'mydata1.txt' inside the 'folder' object
        writeData(myFile,data);
    }

    public void savePublicExternalFile(View view)
    {
        String data=editText.getText().toString();
        File folder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        //'folder' variable will contain a reference to the Downloads folder on the Android by this method
        //here we pass a public Environment variable where the data will be saved.
        File myFile=new File(folder,"mydata4.txt");//this myFile object will refer to the
        // 'mydata1.txt' inside the 'folder' object
        writeData(myFile,data);
    }

    public void next(View view)
    {
        Intent i=new Intent(this,Second.class);
        startActivity(i);
    }

    public void message(String messge)
    {
        Toast.makeText(this,messge,Toast.LENGTH_SHORT).show();
    }
}
