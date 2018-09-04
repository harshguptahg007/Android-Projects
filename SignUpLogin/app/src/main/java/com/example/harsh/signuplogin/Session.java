package com.example.harsh.signuplogin;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by harsh on 30/3/18.
 */

public class Session {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;
    public Session(Context ctx){
        this.ctx=ctx;
        prefs = ctx.getSharedPreferences("myapp",Context.MODE_PRIVATE);
        editor=prefs.edit();
    }

    public void setLoggedIn(boolean loggedIn){
        editor.putBoolean("loggedInmode",loggedIn);
        editor.commit();

    }

    public boolean loggedIn(){
        return prefs.getBoolean("loggedInmode",false);
    }

}
