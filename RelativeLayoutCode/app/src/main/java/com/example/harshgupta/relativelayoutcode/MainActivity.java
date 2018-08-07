package com.example.harshgupta.relativelayoutcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout main;
    TextView message,username,password;
    Button login;
    EditText userNameValue,passwordValue;
    LayoutParams messagedimensions,userNameDimensions,userNameValueDimensions,passwordDimensions,passwordValueDimensions,
            loginDimensions;
    int messageId=1,userNameId=2,userNameValueId=3,passwordId=4,passwordValueId=5,loginId=6;
    int paddingValue=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        createMessageTextView();
        createUserNameTextView();
        createUserNameEditText();
        createPasswordTextView();
        createPasswordEditText();
        createButton();
        main.addView(message,messagedimensions);
        main.addView(username,userNameDimensions);
        main.addView(userNameValue,userNameValueDimensions);
        main.addView(password,passwordDimensions);
        main.addView(passwordValue,passwordValueDimensions);
        main.addView(login,loginDimensions);
        setContentView(main);//here we pass the RelativeLayout object rather tha activity_main to create the appearence
    }

    public void init()
    {
        main=new RelativeLayout(this);
        LayoutParams maindimensions=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        //maindiemsnions contains 2 integer values for width and height as matchparent
        main.setLayoutParams(maindimensions);
        //here the main variable contains the width and height stored in maindimensons
        message=new TextView(this);//Please Login First
        username=new TextView(this);//User Name
        password=new TextView(this);//Password
        login=new Button(this);
        userNameValue=new EditText(this);//here comes the edit text to enter user name
        passwordValue=new EditText(this);
    }

    public void createMessageTextView()
    {
        messagedimensions=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        messagedimensions.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        message.setPadding(paddingValue,100,paddingValue,paddingValue);
        message.setText("Please Login First");
        message.setId(messageId);
        message.setLayoutParams(messagedimensions);
    }
    public void createUserNameTextView()
    {
        userNameDimensions=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        userNameDimensions.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        userNameDimensions.addRule(RelativeLayout.BELOW,messageId);
        username.setPadding(paddingValue,paddingValue,paddingValue,paddingValue);
        username.setText("User Name");
        username.setId(userNameId);
        message.setLayoutParams(messagedimensions);
    }
    public void createUserNameEditText()
    {
        userNameValueDimensions=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        userNameValue.setId(userNameValueId);
        userNameValueDimensions.addRule(RelativeLayout.BELOW,messageId);
        userNameValueDimensions.addRule(RelativeLayout.RIGHT_OF,userNameId);
        userNameValueDimensions.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        userNameValueDimensions.addRule(RelativeLayout.ALIGN_BASELINE,userNameId);
    }
    public void createPasswordTextView()
    {
        passwordDimensions=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        passwordDimensions.addRule(RelativeLayout.BELOW,userNameValueId);
        passwordDimensions.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        passwordDimensions.addRule(RelativeLayout.ALIGN_RIGHT,userNameId);
        password.setPadding(paddingValue,paddingValue,paddingValue,paddingValue);
        password.setGravity(Gravity.RIGHT);
        password.setText("Password");
        password.setId(passwordId);
        password.setLayoutParams(passwordDimensions);
    }
    public void createPasswordEditText()
    {
        passwordValueDimensions=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        passwordValue.setId(passwordValueId);
        passwordValueDimensions.addRule(RelativeLayout.BELOW,userNameValueId);
        passwordValueDimensions.addRule(RelativeLayout.RIGHT_OF,passwordId);
        passwordValueDimensions.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        passwordValueDimensions.addRule(RelativeLayout.ALIGN_BASELINE,passwordId);
    }
    public void createButton()
    {
        loginDimensions=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        loginDimensions.addRule(RelativeLayout.BELOW,passwordValueId);
        loginDimensions.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        login.setId(loginId);
        login.setText("Login");
        login.setLayoutParams(loginDimensions);
    }
}
