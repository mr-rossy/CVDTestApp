package com.mrrossy.cvdtestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    private Button enterButton;
    private EditText matricEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        enterButton = (Button) findViewById(R.id.btnEnterMatric);

    }



    public void startTest(View view){

        Intent test_introIntent = new Intent(this, testIntro.class);
        startActivity(test_introIntent);

    }
}
