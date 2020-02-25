package com.example.nietof.buttonclickdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button rockBtn;
    private Button paperBtn;
    private Button scissorsBtn;

    private ImageView aIChoiceImageView;
    private ImageView playerChoiceImageView;

    private TextView scoreTxtView;
    private TextView feedbackTxtView;

    private int playerScore = 0;
    private int computerScore = 0;

    private boolean playerIsWinner = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        rockBtn = findViewById(R.id.btn_color_change);


    } //end onCreate()

    private View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Random random = new Random();
            int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
            v.setBackgroundColor(color);  //update the view we passed in as v.



            Log.d("onClick: " , " color change!");


        }
    };
}

