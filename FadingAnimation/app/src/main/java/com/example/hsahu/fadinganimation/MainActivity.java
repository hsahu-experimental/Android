package com.example.hsahu.fadinganimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view) {
        Log.d("dgd", "clicked");
        ImageView bart = findViewById(R.id.bart);
        bart.animate().alpha(0f).setDuration(2000).start();
        ImageView homer = findViewById(R.id.homer);
        homer.animate().alpha(1f).setDuration(2000).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
