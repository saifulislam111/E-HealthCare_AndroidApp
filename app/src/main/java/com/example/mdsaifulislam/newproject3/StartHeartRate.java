package com.example.mdsaifulislam.newproject3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartHeartRate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_heart_rate);
    }

    public void HR(View v) {
        Intent i=new Intent(StartHeartRate.this,HeartRateProcess.class);
        startActivity(i);
    }

}
