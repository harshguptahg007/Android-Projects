package com.example.harsh.fetch2;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by harsh on 31/3/18.
 */

public class BackgroundTask3 extends AsyncTask<String,Void,String> {

    Context ctx;
    public BackgroundTask3(Context ctx){
        this.ctx=ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String method="addTeacherInfo";
        if(params[0].equalsIgnoreCase(method)){

            //Read the data
            Teachers teach=new Teachers();
            teach.setName(params[1]);
            teach.setId(Integer.parseInt(params[2]));
            teach.setSubject(params[3]);
            teach.setEmail(params[4]);
            teach.setBranch(params[5]);
            teach.setYear(params[6]);
            teach.setPassword(params[7]);

            Fetch.myTeachersDatabase.myTeachersDao().tableTeachersAdd(teach);

        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
