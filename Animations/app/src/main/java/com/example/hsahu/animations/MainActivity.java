package com.example.hsahu.animations;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    float translationPixels = 100;

    public void translateTop(View view) {
        ImageView homer = findViewById(R.id.homer);
        homer.animate().translationYBy(-1 * translationPixels).setDuration(1000);
    }

    public void translateLeft(View view) {
        ImageView homer = findViewById(R.id.homer);
        homer.animate().translationXBy(-1*translationPixels).setDuration(1000);
    }

    public void translateRight(View view) {
        ImageView homer = findViewById(R.id.homer);
        homer.animate().translationXBy(translationPixels).setDuration(1000);
    }

    public void translateBottom(View view) {
        ImageView homer = findViewById(R.id.homer);
        homer.animate().translationYBy(translationPixels).setDuration(1000);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView homer = findViewById(R.id.homer);
        homer.animate().scaleX(1.3f).scaleY(1.3f).setDuration(1000);

    }
}
