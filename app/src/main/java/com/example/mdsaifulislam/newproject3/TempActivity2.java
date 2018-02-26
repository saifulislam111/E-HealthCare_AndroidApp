package com.example.mdsaifulislam.newproject3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TempActivity2 extends AppCompatActivity {

    EditText etH;
    EditText etR;
    TextView tvT;
    Button btMT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp2);
        etH = (EditText)findViewById(R.id.editText6);
        etR = (EditText)findViewById(R.id.editText7);
        tvT = (TextView)findViewById(R.id.textView3);
        btMT = (Button)findViewById(R.id.button6);
    }
    public void measureTemprature(View v) {
        Context context = TempActivity2.this;
        SharedPreferences sharedPref = getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        int normalHR = sharedPref.getInt(getString(R.string.heart_rate), 0);
        SharedPreferences sharedPref2 = getSharedPreferences(
                getString(R.string.preference_file_key2), Context.MODE_PRIVATE);
        int normalBR = sharedPref2.getInt(getString(R.string.resp_rate), 0);
        Toast.makeText(context,""+normalHR+" "+normalBR,Toast.LENGTH_SHORT).show();
        int currentHR = Integer.parseInt(etH.getText().toString());
        int currentBR = Integer.parseInt(etR.getText().toString());
        double temp = ((37+((currentHR - normalHR+currentBR-normalBR)*1.0/12.0))*9.0/5.0)+32;
//        double temp = currentHR - normalHR + currentBR-normalBR;
        tvT.setText(""+temp+" Farenheit");
    }
}
