package com.example.harsh.fetch2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class LoginTeacher extends AppCompatActivity {

    private EditText tEmail,tPassword;
    private Button tLogin;
    private String tmsg="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_teacher);

        tEmail=(EditText)findViewById(R.id.email_teacher);
        tPassword=(EditText)findViewById(R.id.password_teacher);

        tLogin=(Button)findViewById(R.id.tlogin_button);

        tLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Teachers> teachs=Fetch.myTeachersDatabase.myTeachersDao().getTeachersDetail();

                for(Teachers teac:teachs){

                    String email=teac.getEmail();
                    String pass=teac.getPassword();

                    if(tEmail.getText().toString().equalsIgnoreCase(email)){

                        if(tPassword.getText().toString().equalsIgnoreCase(pass)){
                            tmsg = "User Verified";
                        }else{
                            tmsg = "Invalid User";
                        }

                    }else{
                        tmsg = "Invalid User";
                    }

                }
                Toast.makeText(getApplicationContext(),tmsg,Toast.LENGTH_LONG).show();
            }
        });
    }
}
