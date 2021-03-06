package com.mrrossy.cvdtestapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Q3Blue extends AppCompatActivity {

    public Test testGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q3_blue);

        Intent _theintent = getIntent();
        testGo = (Test)_theintent.getSerializableExtra("testGo");

        String matric = testGo.get_matric();

        final MediaPlayer canyouPlayer = MediaPlayer.create(this, R.raw.canyouseewhatcolouriam);




        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                canyouPlayer.start();
            }
        }, 500);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent answerIntent = new Intent(Q3Blue.this, A3Blue.class);
                answerIntent.putExtra("testGo", testGo);
                Q3Blue.this.startActivity(answerIntent);
                Q3Blue.this.finish();
            }
        }, 5000);
    }
}

