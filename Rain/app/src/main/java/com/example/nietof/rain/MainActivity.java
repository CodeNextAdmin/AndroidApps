package com.example.nietof.rain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button showMoney;
    private Button showTag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        showMoney = findViewById(R.id.add_money_btn);
        showTag = findViewById(R.id.show_tag_btn);




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }


   
}
