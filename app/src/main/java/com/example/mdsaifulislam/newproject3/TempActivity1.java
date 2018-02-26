package com.example.mdsaifulislam.newproject3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TempActivity1 extends AppCompatActivity {

    Button sherdPrefButton;
    Button temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp1);
        sherdPrefButton = (Button)findViewById(R.id.button2);
        temp = (Button)findViewById(R.id.button4);
    }
    public void sherdPrefInput(View v){
        Intent i = new Intent(TempActivity1.this,SharedPrefTemp.class);
        startActivity(i);
    }
    public void tempInput(View v){
        Intent i = new Intent(TempActivity1.this,TempActivity2.class);
        startActivity(i);
    }
}
