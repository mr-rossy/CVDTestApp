package com.mrrossy.cvdtestapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class A1Yellow extends AppCompatActivity {

    public long tStart = System.currentTimeMillis();
    TableLayout answerTable;
    ImageButton imgBtn1, imgBtn2, imgBtn3, imgBtn4;
    private Thread threada;
    private long lastClickTime = 0;
    String timeSecs;
    String answer;
    String timeTaken;

    public Test testGo;
    dbHelper theDB;

    MediaPlayer thePlayer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1_yellow);

        Intent _intent = getIntent();
        testGo = (Test)_intent.getSerializableExtra("testGo");
        String matric = testGo.get_matric();




        playAudioWhatColourWasI();

     /*   threada = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(4000);
                        playIfYouAreNotSure();
                    }
                } catch (InterruptedException ex) {

                }
            }
        };


        threada.start();
*/
        /*MediaPlayer welldonePlayer = MediaPlayer.create(this, R.raw.welldoneletsdoanother);*/


        imgBtn1 = (ImageButton) findViewById(R.id.imageButton1);
        imgBtn2 = (ImageButton) findViewById(R.id.imageButton2);
        imgBtn3 = (ImageButton) findViewById(R.id.imageButton3);
        imgBtn4 = (ImageButton) findViewById(R.id.imageButton4);

        answerTable = (TableLayout) findViewById(R.id.answerTable);



        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

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
       // threada.start();

        // green button
        imgBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateTime();

                testGo.set_q1ans("green");
                answer = "green";


                if (SystemClock.elapsedRealtime() - lastClickTime < 100) {
                    return;
                }
                lastClickTime = SystemClock.elapsedRealtime();

                Toast.makeText(getApplicationContext(), "This works", Toast.LENGTH_LONG).show();
                playAudioWellDone();

                delayThread.start();

            }
        });

        // blue button

        imgBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateTime();

                answer = "blue";
                testGo.set_q1ans("blue");

                if (SystemClock.elapsedRealtime() - lastClickTime < 100) {
                    return;
                }
                lastClickTime = SystemClock.elapsedRealtime();

                Toast.makeText(getApplicationContext(), "This works", Toast.LENGTH_LONG).show();
                playAudioWellDone();

                delayThread.start();

            }
        });

        // red button

        imgBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateTime();

                testGo.set_q1ans("red");
                answer = "red";

                if (SystemClock.elapsedRealtime() - lastClickTime < 100) {
                    return;
                }
                lastClickTime = SystemClock.elapsedRealtime();

                Toast.makeText(getApplicationContext(), "This works", Toast.LENGTH_LONG).show();
                playAudioWellDone();

                delayThread.start();

            }
        });

        // yellow button

        imgBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateTime();

                testGo.set_q1ans("yellow");
                answer = "yellow";

                if (SystemClock.elapsedRealtime() - lastClickTime < 100) {
                    return;
                }
                lastClickTime = SystemClock.elapsedRealtime();

                Toast.makeText(getApplicationContext(), "This works", Toast.LENGTH_LONG).show();
                playAudioWellDone();

                delayThread.start();

            }
        });



        // on click listener for imagebutton1 (green)
  /*      imgBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTime();

    //             Hide other buttons
                imgBtn2.setVisibility(View.GONE);
                imgBtn3.setVisibility(View.GONE);
                imgBtn4.setVisibility(View.GONE);*//*
             *//*   stopPlaying();*//*
                Toast.makeText(getApplicationContext(), "This works", Toast.LENGTH_LONG).show();
   //             playAudioWellDone();

     //           delayThread.start();


   //         }
   //     });*/

        // on click listener for imagebutton2 (blue)
      /*  imgBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTime();
               *//* stopPlaying();*//*
              *//*  imgBtn1.setVisibility(View.GONE);
                imgBtn3.setVisibility(View.GONE);
                imgBtn4.setVisibility(View.GONE);*//*
                Toast.makeText(getApplicationContext(), "This works", Toast.LENGTH_LONG).show();
                playAudioWellDone();

                final Intent nextQ = new Intent(view.getContext(), Q2Red.class);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(nextQ);
                    }
                }, 2000);

            }
        });

        // on click listener for imagebutton3 (red)
        imgBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTime();
               *//* stopPlaying();*//*
                *//*imgBtn2.setVisibility(View.GONE);
                imgBtn1.setVisibility(View.GONE);
                imgBtn4.setVisibility(View.GONE);*//*

                Toast.makeText(getApplicationContext(), "This works", Toast.LENGTH_LONG).show();
                final Intent nextQ = new Intent(view.getContext(), Q2Red.class);
                playAudioWellDone();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(nextQ);
                    }
                }, 2000);

            }
        });

        // on click listener for imagebutton4 (yellow)
        imgBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTime();
                *//*stopPlaying();*//*
                *//*imgBtn2.setVisibility(View.GONE);
                imgBtn3.setVisibility(View.GONE);
                imgBtn1.setVisibility(View.GONE);*//*

                Toast.makeText(getApplicationContext(), "This works", Toast.LENGTH_LONG).show();
                playAudioWellDone();
                final Intent nextQ = new Intent(view.getContext(), Q2Red.class);

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(nextQ);
                    }
                }, 2000);

            }
        });

    }
*/

    }
    @Override
    protected void onStop() {
        super.onStop();
        if(thePlayer != null) {
            thePlayer.stop();
            thePlayer.reset();
            thePlayer.release();
        }
    }

    // method to start timer
    public void timeStart() {
        tStart = System.currentTimeMillis();
    }


    // method to calculate time elapsed
    public void calculateTime() {
        long tEnd = System.currentTimeMillis();
        System.out.println(tEnd);
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;
        System.out.println(elapsedSeconds);
        timeTaken = Double.toString(elapsedSeconds);
        testGo.set_q1time(timeTaken);
       /* timeSecs = Double.toString(elapsedSeconds);
        testGo.set_q1time(timeSecs);*/
    }

    // method to make table visible to user
    public void makeTableVisible() {
        answerTable.setVisibility(View.VISIBLE);
        timeStart();
    }


    // play message saying what colour was I
    private void playAudioWhatColourWasI() {
        final MediaPlayer thePlayer = MediaPlayer.create(this, R.raw.whatcolourwasi);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                thePlayer.start();

            }
        }, 1000);

    }

    // method to play audio saying well done after 1.5 seconds

    private void playAudioWellDone() {

        MediaPlayer thePlayer = MediaPlayer.create(this, R.raw.welldoneletsdoanother);
        thePlayer.start();

        /*new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                thePlayer.start();
            }
        }, 100);*/

    }

    public void addAnswer() {

        testGo.set_q1ans(answer);
    }



    @Override
    public boolean onTouchEvent(MotionEvent evt)
    {
        if(evt.getAction() == MotionEvent.ACTION_DOWN)
        {
            synchronized (threada){
                threada.notifyAll();
            }
        }
        return true;
    }


    private void playIfYouAreNotSure() {

            if(thePlayer.isPlaying()){
                thePlayer.stop();
                return;
            }

            MediaPlayer thePlayer = MediaPlayer.create(this, R.raw.ifyouarenotsurerememberorguess);
            thePlayer.start();
    }

/*
    private void stopPlaying() {
        if (thePlayer!= null) {
            thePlayer.stop();
            thePlayer.release();
            thePlayer = null;
        }
    }*/

/*
    public void nextQ(View view){

        Intent nextQIntent  = new Intent(this, Q2Red.class);

        startActivity(nextQIntent);
    }

*/

    Thread delayThread = new Thread() {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            Intent i = new Intent(A1Yellow.this, Q2Red.class);
            testGo.set_q1ans(answer);
            i.putExtra("testGo", testGo);

            startActivity(i);
        }
    };

}

