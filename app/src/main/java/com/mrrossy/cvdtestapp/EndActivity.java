package com.mrrossy.cvdtestapp;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        MediaPlayer thePlayer = MediaPlayer.create(this, R.raw.thanksomuchhaveagreatday);
        thePlayer.start();





    }
}
