package com.example.hsahu.currencyconverter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void onClickFunction(View view) {
        EditText amount = (EditText) findViewById(R.id.convert_text);

        double doubleValue = 0;
        try {
            doubleValue = Double.parseDouble(amount.getText().toString());
            double conversionRate = 65.5;
            double convertedValue = conversionRate * doubleValue;
            Toast.makeText(MainActivity.this, Double.toString(convertedValue) + " $", Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException nfe) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Please Enter numbers only").setTitle("Invalid Input").create().show();
            amount.setText("");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
