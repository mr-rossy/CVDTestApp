package com.mrrossy.cvdtestapp;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Timer;
import java.util.TimerTask;

public class testIntro extends AppCompatActivity {

    ImageButton brownDog;
    public Test testGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent _intent = getIntent();
        testGo = (Test)_intent.getSerializableExtra("testGo");


        String userMatric = testGo.get_matric();

        brownDog = (ImageButton) findViewById(R.id.imgBtnBrownDog);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_intro);

        playAudio();



    }

    public void playAudio()
    {
        MediaPlayer introPlayer = MediaPlayer.create(this, R.raw.greetinghellomynameisace);

        introPlayer.start();

    }

    public void pauseAudio()
    {

    }


    public void startq1Yellow(View view){

        Intent q1yellowIntent = new Intent(this, Q1Yellow.class);
        q1yellowIntent.putExtra("testGo", testGo);
        startActivity(q1yellowIntent);

    }

    public void makeClickable() {
        brownDog.setEnabled(true);
    }


}
