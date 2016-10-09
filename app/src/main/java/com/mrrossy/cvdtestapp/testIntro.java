package com.mrrossy.cvdtestapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class testIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_intro);

        playAudio();

    }

    private void playAudio()
    {
        MediaPlayer introPlayer = MediaPlayer.create(this, R.raw.greetinghellomynameisace);
        introPlayer.start();
    }


    public void startq1Yellow(View view){
        Intent q1yellowIntent = new Intent(this, Q1Yellow.class);
        startActivity(q1yellowIntent);
    }



}
