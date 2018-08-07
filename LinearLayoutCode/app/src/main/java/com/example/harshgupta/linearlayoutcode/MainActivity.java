package com.example.harshgupta.linearlayoutcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;
    TextView t;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ll=new LinearLayout(this);
        t=new TextView(this);
        b=new Button(this);

        LinearLayout.LayoutParams dimensions=new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams dimensions2=new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(dimensions);
        t.setLayoutParams(dimensions2);
        b.setLayoutParams(dimensions2);

        ll.setOrientation(LinearLayout.VERTICAL);
        t.setText("Hello World");
        b.setText("Button");

        ll.addView(t);
        ll.addView(b);

        setContentView(ll);
    }
}
