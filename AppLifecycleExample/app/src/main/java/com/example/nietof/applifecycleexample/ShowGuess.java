package com.example.nietof.applifecycleexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ShowGuess extends AppCompatActivity {

    private TextView showName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);


         showName = findViewById(R.id.received_txt);

         String value = getIntent().getStringExtra("name");

         showName.setText(value);


         showName.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent myIntent = getIntent();
                 myIntent.putExtra("reply", "Welcome back!");

                 setResult(RESULT_OK, myIntent);
             }
         });


    }
}
