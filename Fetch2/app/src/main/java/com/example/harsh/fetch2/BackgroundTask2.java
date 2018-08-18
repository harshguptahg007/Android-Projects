package com.example.harsh.fetch2;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by harsh on 31/3/18.
 */


public class BackgroundTask2 extends AsyncTask<String,Void,String>{

    Context ctx;
    public BackgroundTask2(Context ctx){
        this.ctx=ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String method="addStudentInfo";
        if(params[0].equalsIgnoreCase(method)){
            //Read the data
            Students stud=new Students();
            stud.setName(params[1]);
            stud.setFather(params[2]);
            stud.setRollNo(Integer.parseInt(params[3]));
            stud.setStudentNo(Integer.parseInt(params[4]));
            stud.setBranch(params[5]);
            stud.setYear(params[6]);
            stud.setSection(params[7]);
            stud.setCurrent_sem(Integer.parseInt(params[8]));
            stud.setDOB(params[9]);
            stud.setContact(Long.parseLong(params[10]));
            stud.setParent_contact(Long.parseLong(params[11]));
            stud.setEmail(params[12]);
            stud.setHigh_School(Double.parseDouble(params[13]));
            stud.setIntermediate(Double.parseDouble(params[14]));
            stud.setB_tech(Double.parseDouble(params[15]));
            if(params[16].length()>0) {
                stud.setSem_1_marks(Double.parseDouble(params[16]));
            }else{
                stud.setSem_1_marks(0);
            }
            if(params[17].length()>0) {
                stud.setSem_1_attendence(Double.parseDouble(params[17]));
            }else{
                stud.setSem_1_attendence(0);
            }
            if(params[18].length()>0) {
                stud.setSem_2_marks(Double.parseDouble(params[18]));
            }else{
                stud.setSem_2_marks(0);
            }
            if(params[19].length()>0) {
                stud.setSem_2_attendence(Double.parseDouble(params[19]));
            }else{
                stud.setSem_2_attendence(0);
            }
            if(params[20].length()>0) {
                stud.setSem_3_marks(Double.parseDouble(params[20]));
            }else{
                stud.setSem_3_marks(0);
            }
            if(params[21].length()>0) {
                stud.setSem_3_attendence(Double.parseDouble(params[21]));
            }else{
                stud.setSem_3_attendence(0);
            }
            if(params[22].length()>0) {
                stud.setSem_4_marks(Double.parseDouble(params[22]));
            }else{
                stud.setSem_4_marks(0);
            }
            if(params[23].length()>0) {
                stud.setSem_4_attendence(Double.parseDouble(params[23]));
            }else{
                stud.setSem_4_attendence(0);
            }
            if(params[24].length()>0) {
                stud.setSem_5_marks(Double.parseDouble(params[24]));
            }else{
                stud.setSem_5_marks(0);
            }
            if(params[25].length()>0) {
                stud.setSem_5_attendence(Double.parseDouble(params[25]));
            }else{
                stud.setSem_5_attendence(0);
            }
            if(params[26].length()>0) {
                stud.setSem_6_marks(Double.parseDouble(params[26]));
            }else{
                stud.setSem_6_marks(0);
            }
            if(params[27].length()>0) {
                stud.setSem_6_attendence(Double.parseDouble(params[27]));
            }else{
                stud.setSem_6_attendence(0);
            }


            Fetch.myStudentsDatabase.myStudentsDao().tableStudentsAdd(stud);
        }

        return "";
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
