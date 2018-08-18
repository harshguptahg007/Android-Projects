package com.example.harsh.fetch2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ViewLogin extends AppCompatActivity {

    private TextView TxtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_login);

        TxtInfo=(TextView)findViewById(R.id.txt_display_info);

        List<Students> students=Fetch.myStudentsDatabase.myStudentsDao().getStudentLoginDetails();

        String info="";
        int i=0;

        for(Students stud:students){

            String email=stud.getEmail();
            int roll=stud.getRollNo();

            i++;

            info=info+"\n\nEmail : "+email+"\nRoll No : "+roll;

        }

        TxtInfo.setText(info);
        Toast.makeText(getApplicationContext(),"Added : "+i,Toast.LENGTH_SHORT).show();
    }
}
