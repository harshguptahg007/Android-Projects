package com.example.harsh.fetch2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ViewStudentDetails extends AppCompatActivity {

    private TextView TxtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student_details);

        TxtInfo=(TextView)findViewById(R.id.txt_display_info);

        List<Students> users=Fetch.myStudentsDatabase.myStudentsDao().getStudentsDetails();

        String info="";
        int i=0;

        for(Students stud:users){

            String name=stud.getName();
            String father=stud.getFather();
            int roll=stud.getRollNo();
            int studNo=stud.getStudentNo();
            String bran=stud.getBranch();
            String year=stud.getYear();
            String sec=stud.getSection();
            int current=stud.getCurrent_sem();
            String dob=stud.getDOB();
            long cont=stud.getContact();
            long parent_cont=stud.getParent_contact();
            String mail=stud.getEmail();
            double high_school=stud.getHigh_School();
            double intermediate=stud.getIntermediate();
            double b_tech=stud.getB_tech();
            double sem_1_mark=stud.getSem_1_marks();
            double sem_1_attend=stud.getSem_1_attendence();
            double sem_2_mark=stud.getSem_2_marks();
            double sem_2_attend=stud.getSem_2_attendence();
            double sem_3_mark=stud.getSem_3_marks();
            double sem_3_attend=stud.getSem_3_attendence();
            double sem_4_mark=stud.getSem_4_marks();
            double sem_4_attend=stud.getSem_4_attendence();
            double sem_5_mark=stud.getSem_5_marks();
            double sem_5_attend=stud.getSem_5_attendence();
            double sem_6_mark=stud.getSem_6_marks();
            double sem_6_attend=stud.getSem_6_attendence();
            double sem_7_mark=stud.getSem_7_marks();
            double sem_7_attend=stud.getSem_7_attendence();
            double sem_8_mark=stud.getSem_8_marks();
            double sem_8_attend=stud.getSem_8_attendence();

            i++;

            info=info+"\n\n"+"Name : "+name+"\nFather name"+father+"\nRollNo : "+roll+"\nStudentNo : "+studNo+ "\nBranch : "+bran+
                    "\nYear : "+year+"\nSec : "+sec+"\nCurrent Semester : "+current+"\nDOB : "+dob+"\nContact : "+cont+
                    "\nParent Contact : "+parent_cont+"\nEmail : "+mail+"\nHigh School : "+high_school+"\nIntermediate : "+intermediate+
                    "\nB.tech : "+b_tech+"\nSemester 1 Marks : "+sem_1_mark+"\nSemester 1 Attendence : "+sem_1_attend+
                    "\nSemester 2 Marks : "+sem_2_mark+"\nSemester 2 Attendence : "+sem_2_attend+
                    "\nSemester 3 Marks : "+sem_3_mark+"\nSemester 3 Attendence : "+sem_3_attend+
                    "\nSemester 4 Marks : "+sem_4_mark+"\nSemester 4 Attendence : "+sem_4_attend+
                    "\nSemester 5 Marks : "+sem_5_mark+"\nSemester 5 Attendence : "+sem_5_attend+
                    "\nSemester 6 Marks : "+sem_6_mark+"\nSemester 6 Attendence : "+sem_6_attend+
                    "\nSemester 7 Marks : "+sem_7_mark+"\nSemester 7 Attendence : "+sem_7_attend+
                    "\nSemester 8 Marks : "+sem_8_mark+"\nSemester 8 Attendence : "+sem_8_attend;

        }

        TxtInfo.setText(info);
        Toast.makeText(getApplicationContext(),"Added : "+i,Toast.LENGTH_SHORT).show();
    }
}
