package com.example.android.internalstoragetest;

import android.content.Context;
import android.content.Intent;
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

    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.userName_editText);
        password=findViewById(R.id.password_editText);
    }

    public void save(View view)  {
        String text1=username.getText().toString();
        String text2=password.getText().toString();

        text1=text1+" ";

        //writing the data in the internal memory
        FileOutputStream fileOutputStream= null;
        File file = null;
        try {
            fileOutputStream = openFileOutput("vivz.txt", Context.MODE_PRIVATE);
            //FileOutputStream class is used to write data in the files.
            file=getFilesDir();//getting the path where the files are being stored.

            fileOutputStream.write(text1.getBytes());//converting the string into binary and then storing it.
            fileOutputStream.write(text2.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this,"Saved Successfully "+file+" /vivz.txt",Toast.LENGTH_SHORT).show();
    }

    public void next(View view)
    {
        Toast.makeText(this,"Next Called",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
