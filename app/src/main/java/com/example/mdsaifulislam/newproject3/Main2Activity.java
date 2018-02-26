package com.example.mdsaifulislam.newproject3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText age, wei, hei;
    private Toast mainToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        age = (EditText) findViewById(R.id.editText);
        wei = (EditText) findViewById(R.id.editText2);
        hei = (EditText) findViewById(R.id.editText3);
    }

    public void BP(View v) {
        String agestr = age.getText().toString();
        String weistr = wei.getText().toString();
        String heistr = hei.getText().toString();
        if (!agestr.equals("") && !weistr.equals("") && !heistr.equals("")) {
            Double age = Double.parseDouble(agestr);
            Double wei = Double.parseDouble(weistr);
            Double hei = Double.parseDouble(heistr);

            if((age != 0) && (wei != 0)){
                Intent i=new Intent(Main2Activity.this,BloodPressureProcess.class);
                Bundle b = new Bundle();
                b.putDouble("age", age);
                b.putDouble("wei", wei);
                b.putDouble("hei", hei);
                i.putExtras(b);
                startActivity(i);
                finish();}

        } else {

            mainToast = Toast.makeText(getApplicationContext(), "Plz input the fields first", Toast.LENGTH_SHORT);
            mainToast.show();
        }

    }

//    public void HR(View v) {
//        Intent i=new Intent(Main2Activity.this,HeartRateProcess.class);
//        startActivity(i);
//    }
}