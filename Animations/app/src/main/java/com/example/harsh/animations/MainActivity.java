package com.example.harsh.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view) {

        ImageView image = (ImageView) findViewById(R.id.image1);
        ImageView image2 = (ImageView) findViewById(R.id.image2);

        image.animate().translationXBy(1000f).translationYBy(1000f).rotationYBy(3600).setDuration(5000);
        image2.animate().alpha(0f).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image = (ImageView) findViewById(R.id.image1);
        image.setTranslationX(-1000f);
        image.setTranslationY(-1000f);
    }
}
