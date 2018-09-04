package com.example.harsh.signuplogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button login,register;
    private EditText etEmail,etPass;
    private DbHelper db;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DbHelper(this);
        session = new Session(this);
        login=(Button)findViewById(R.id.btnLogin);
        register=(Button)findViewById(R.id.btnReg);
        etEmail=(EditText)findViewById(R.id.email);
        etPass=(EditText)findViewById(R.id.password);

        login.setOnClickListener(this);
        register.setOnClickListener(this);

        if(session.loggedIn()){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnLogin:
                login();
                break;

            case R.id.btnReg:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
                default:

        }
    }

    private void login(){

        String email=etEmail.getText().toString();
        String pass=etPass.getText().toString();

        if(db.getUser(email,pass)){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }else{
            Toast.makeText(getApplicationContext(),"Wrong email/password",Toast.LENGTH_SHORT).show();
        }
    }
}
