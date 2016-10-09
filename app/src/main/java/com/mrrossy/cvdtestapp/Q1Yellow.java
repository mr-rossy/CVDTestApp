package com.mrrossy.cvdtestapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Q1Yellow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1_yellow);

        playAudio();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent answerIntent = new Intent(Q1Yellow.this, A1Yellow.class);
                Q1Yellow.this.startActivity(answerIntent);
                Q1Yellow.this.finish();
            }
        }, 5000);



    }



    private void playAudio()
    {
        MediaPlayer introPlayer = MediaPlayer.create(this, R.raw.canyouseewhatcolouriam);
        introPlayer.start();
    }
}
