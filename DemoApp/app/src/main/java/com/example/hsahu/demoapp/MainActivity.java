package com.example.hsahu.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void changeImage(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.cat2);
    }

    public void clickFunction(View view) {
        EditText username = (EditText)findViewById(R.id.editTextUsername);
        EditText password = (EditText)findViewById(R.id.editTextPassword);
        Toast.makeText(MainActivity.this, username.getText().toString() + "@" + password.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
