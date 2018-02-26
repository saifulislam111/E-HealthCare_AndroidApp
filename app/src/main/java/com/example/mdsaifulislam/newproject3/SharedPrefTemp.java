package com.example.mdsaifulislam.newproject3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SharedPrefTemp extends AppCompatActivity {
    EditText etHeart;
    EditText etResp;
    Button btSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref_temp);
        etHeart = (EditText)findViewById(R.id.editText4);
        etResp = (EditText)findViewById(R.id.editText5);
        btSave = (Button)findViewById(R.id.button5);

    }
    public void save(View v) {
        Context context = SharedPrefTemp.this;
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(getString(R.string.heart_rate), Integer.parseInt(etHeart.getText().toString()));
        editor.commit();

        SharedPreferences sharedPref2 = context.getSharedPreferences(
                getString(R.string.preference_file_key2), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        editor2.putInt(getString(R.string.resp_rate), Integer.parseInt(etResp.getText().toString()));
        editor2.commit();
        Intent intent = new Intent(SharedPrefTemp.this,TempActivity2.class);
        startActivity(intent);
    }
}
