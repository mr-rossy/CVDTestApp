package com.mrrossy.cvdtestapp;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class EndActivity extends AppCompatActivity {

    public Test testGo;
    ImageButton brownDog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        dbHelper myDB = new dbHelper(this);

        brownDog = (ImageButton) findViewById(R.id.imgBtnBrownDog);





        Intent _anIntent = getIntent();
        testGo = (Test) _anIntent.getSerializableExtra("testGo");

        myDB.addTest(testGo);


        MediaPlayer thePlayer = MediaPlayer.create(this, R.raw.thanksomuchhaveagreatday);
        thePlayer.start();





    }

    public void endClick (View view) {

        Intent endIntent = new Intent(this, StartActivity.class);
        startActivity(endIntent);
    }
}
