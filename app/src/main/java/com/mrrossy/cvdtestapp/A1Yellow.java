package com.mrrossy.cvdtestapp;

import android.content.Intent;
import android.content.res.TypedArray;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;

import java.util.Random;

public class A1Yellow extends AppCompatActivity {

    public long tStart;
    TableLayout answerTable;
    ImageButton imgBtn1, imgBtn2, imgBtn3, imgBtn4;

//    final TypedArray imgs = getResources().obtainTypedArray(R.array.btnColours);
//    final Random rand = new Random();
//    final int rndInt = rand.nextInt(imgs.length());
//    final int resID = imgs.getResourceId(rndInt, 0);

    /*int[] imageIDs = {
            R.drawable.btnColour1,
            R.drawable.btnColour2,
            R.drawable.btnColour3,
            R.drawable.btnColour4
    };*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1_yellow);


        imgBtn1 = (ImageButton)findViewById(R.id.imageButton1);
        imgBtn2 = (ImageButton)findViewById(R.id.imageButton2);
        imgBtn3 = (ImageButton)findViewById(R.id.imageButton3);
        imgBtn4 = (ImageButton)findViewById(R.id.imageButton4);

        answerTable = (TableLayout)findViewById(R.id.answerTable);

        playAudio();

        Thread thread = new Thread() {
            @Override
            public void run(){
                try {
                    Thread.sleep(1500);
                }catch (InterruptedException e) {

                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        makeTableVisible();
                    }
                });
            }
        };
        thread.start();





    }

    public void greenAnswer(View view)
    {
       // calculateTime();
        nextQuestion(view);


    }

    public void nextQuestion(View view)
    {
        
    }

    // method to start timer
    public void timeStart(){
        tStart = System.currentTimeMillis();
    }


    // method to calculate time elapsed
    public void calculateTime()
    {
        long tEnd = System.currentTimeMillis();
        System.out.println(tEnd);
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;
        System.out.println(elapsedSeconds);
    }

    // method to make table visible to user
    public void makeTableVisible()
    {
    answerTable.setVisibility(View.VISIBLE);
        timeStart();
    }



    // play message saying what colour was I
    private void playAudio()
    {
        MediaPlayer introPlayer = MediaPlayer.create(this, R.raw.whatcolourwasi);
        introPlayer.start();
    }



}
