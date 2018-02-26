package com.example.mdsaifulislam.newproject3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class HeartRateResult extends AppCompatActivity {

//    private String user,Date;
    int HR;
//    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//    Date today = Calendar.getInstance().getTime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rate_result);

//        Date = df.format(today);
        TextView RHR = (TextView) this.findViewById(R.id.HRR);
        //  ImageButton SHR = (ImageButton)this.findViewById(R.id.SendHR);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            HR = bundle.getInt("bpm");
            //   user = bundle.getString("Usr");
            //  Log.d("DEBUG_TAG", "ccccc"+ user);
            RHR.setText(String.valueOf(HR));
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(HeartRateResult.this, MainActivity.class);
        //  i.putExtra("Usr", user);
        startActivity(i);
        finish();
    }
}
