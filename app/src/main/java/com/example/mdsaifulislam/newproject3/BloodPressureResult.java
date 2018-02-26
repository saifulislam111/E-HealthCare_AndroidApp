package com.example.mdsaifulislam.newproject3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BloodPressureResult extends AppCompatActivity {

//    private String user,Date;
    int SP,DP;
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date today = Calendar.getInstance().getTime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_pressure_result);

//        Date = df.format(today);
        TextView TBP = (TextView) this.findViewById(R.id.BPT);
        //ImageButton SBP = (ImageButton)this.findViewById(R.id.SendBP);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            SP = bundle.getInt("SP");
            DP = bundle.getInt("DP");
//            user = bundle.getString("Usr");
            TBP.setText(String.valueOf(SP+" / "+DP));
        }


    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(BloodPressureResult.this, MainActivity.class);
        //   i.putExtra("Usr", user);
        startActivity(i);
        finish();
        super.onBackPressed();

    }
}
