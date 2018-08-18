package com.example.harsh.fetch2;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by harsh on 31/3/18.
 */

public class BackgroundTask extends AsyncTask<String,Void,String> {

    Context ctx;
    public BackgroundTask(Context ctx){
        this.ctx=ctx;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String ... params) {

        String method=params[0];
        if(params[0].equalsIgnoreCase(method)){

            //Read the data
            Predictions predict=new Predictions();
            predict.setName(params[1]);
            predict.setRollNo(Integer.parseInt(params[2]));
            predict.setBranch(params[3]);
            predict.setPredicted_marks(Double.parseDouble(params[4]));
            predict.setPredicted_drop(Double.parseDouble(params[5]));
            predict.setPersonality(params[6]);
            predict.setRecommended1(params[7]);
            predict.setRecommended2(params[8]);
            predict.setRecommended3(params[9]);
            predict.setRecommended4(params[10]);
            predict.setRecommended5(params[11]);
        
            Fetch.myAppDatabase.myPredictionsDao().tablePredictionsAdd(predict);
        }
        
        return "";
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
    }


}
