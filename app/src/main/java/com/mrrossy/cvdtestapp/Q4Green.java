package com.mrrossy.cvdtestapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Q4Green extends AppCompatActivity {

    public Test testGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4_green);

        final MediaPlayer canyouPlayer = MediaPlayer.create(this, R.raw.canyouseewhatcolouriam);


        Intent _intent = getIntent();
        testGo = (Test)_intent.getSerializableExtra("testGo");
        String matric = testGo.get_matric();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                canyouPlayer.start();
            }
        }, 1000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent answerIntent = new Intent(Q4Green.this, A4Green.class);
                answerIntent.putExtra("testGo", testGo);
                Q4Green.this.startActivity(answerIntent);
                Q4Green.this.finish();
            }
        }, 5000);


    }
}
