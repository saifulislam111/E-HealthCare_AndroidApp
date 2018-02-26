package com.example.mdsaifulislam.newproject3;

import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainResActivity extends AppCompatActivity {

    private RecordingThread mRecordingThread;
    private static final int REQUEST_RECORD_AUDIO = 13;

    private AudioDataReceivedListener ad_receiver;

    Button btn_start,btn_stop;
    TextView txt_db_show;
    double db,d_max;
    public static ArrayList<Double> raw_audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_record);

        btn_start = (Button)findViewById(R.id.button_start_recording);
//        btn_stop = (Button)findViewById(R.id.button_stop_recording);
        txt_db_show = (TextView)findViewById(R.id.textView_show_db);

        ad_receiver = new AudioDataReceivedListener() {
            @Override
            public void onAudioDataReceived(short[] data) {

            }
        };

        mRecordingThread = new RecordingThread(ad_receiver,getApplicationContext());

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long startTime = System.currentTimeMillis();
                long TIME = 20000;
                if (!mRecordingThread.recording()) {
                    Log.e("in tag","before");
                    startAudioRecordingSafe();
                    Log.e("in tag","after");
                } else {
                    mRecordingThread.stopRecording();
                    startAudioRecordingSafe();
                }
                while (true) {
                    long endTime = System.currentTimeMillis();
                    if(endTime - startTime >= TIME) {
                        mRecordingThread.stopRecording();
                        ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 200);
                        toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP,200);
                        break;
                    }
                }
                raw_audio = mRecordingThread.raw_audio;
                txt_db_show.setText(""+(int)Breath.solve());

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        mRecordingThread.stopRecording();
    }

    private void startAudioRecordingSafe() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO)
                == PackageManager.PERMISSION_GRANTED) {
            mRecordingThread.startRecording();
        } else {
            requestMicrophonePermission();
        }
    }


    private void requestMicrophonePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.RECORD_AUDIO)) {
            // Show dialog explaining why we need record audio
                    ActivityCompat.requestPermissions(MainResActivity.this, new String[]{
                            android.Manifest.permission.RECORD_AUDIO}, REQUEST_RECORD_AUDIO);

        } else {
            ActivityCompat.requestPermissions(MainResActivity.this, new String[]{
                    android.Manifest.permission.RECORD_AUDIO}, REQUEST_RECORD_AUDIO);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_RECORD_AUDIO && grantResults.length > 0 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            mRecordingThread.stopRecording();
        }
    }
}

