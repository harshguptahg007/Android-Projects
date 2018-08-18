package com.example.harsh.fetch2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ViewPredictionsDetails extends AppCompatActivity {

    private TextView TxtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_predictions_details);

        TxtInfo=(TextView)findViewById(R.id.txt_display_info);

        List<Predictions> users=Fetch.myAppDatabase.myPredictionsDao().getUsers();

        String info="";
        int i=0;

        for(Predictions pred:users){

            String name=pred.getName();
            int roll=pred.getRollNo();
            String bran=pred.getBranch();
            Double mark=pred.getPredicted_marks();
            Double drp=pred.getPredicted_drop();
            String persn=pred.getPersonality();
            String recom1=pred.getRecommended1();
            String recom2=pred.getRecommended2();
            String recom3=pred.getRecommended3();
            String recom4=pred.getRecommended4();
            String recom5=pred.getRecommended5();

            i++;

            info=info+"\n\n"+"Name : "+name+"\nRollNo : "+roll+"\nBranch : "+bran+"\nPredicted Marks : "+mark+"\nPredicted Drop : "+drp
                    +"\nPersonality : "+persn+"\nRecommeded1 : "+recom1+"\nRecommeded2 : "+recom2+"\nRecommeded3 : "+recom3
                    +"\nRecommeded4 : "+recom4+"\nRecommeded5 : "+recom5;
        }

        TxtInfo.setText(info);
        Toast.makeText(getApplicationContext(),"Added : "+i,Toast.LENGTH_SHORT).show();
    }
}
