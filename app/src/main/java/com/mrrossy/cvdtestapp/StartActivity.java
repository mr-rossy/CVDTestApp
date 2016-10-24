package com.mrrossy.cvdtestapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class StartActivity extends AppCompatActivity implements Serializable {

    private Button enterButton;
    private EditText matricText;
    public Test theTest;
    public dbHelper theDBHelper;

    public String matric;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);



        enterButton = (Button) findViewById(R.id.btnEnterMatric);
        matricText = (EditText) findViewById(R.id.matricEnterEditText);



        ContentValues values = new ContentValues();


    }




  /*  public void startTest(View view){

            Bundle b = new Bundle();
        b.putString("test", matric);

        Intent test_introIntent = new Intent(this, testIntro.class);
        startActivity(test_introIntent);

        }*/

    // check if matric number given has 8 digits, if it hasn't show message, if it has pass matric to bundle

    public void checkMatric(View view) {

        matric = matricText.getText().toString();

        if(matric.length() < 8) {
            Toast.makeText(getApplicationContext(), "Your matriculation number should have 8 digits!", Toast.LENGTH_LONG).show();

        }
        else
        {
           /* dbHelper db = new dbHelper(this);*/
            Test testGo = new Test();
            testGo._matric = matric;
            Intent test_introIntent = new Intent(this, testIntro.class);
            test_introIntent.putExtra("testGo", testGo);
            startActivity(test_introIntent);

        }
    }



}
