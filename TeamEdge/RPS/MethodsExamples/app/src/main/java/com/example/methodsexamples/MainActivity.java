package com.example.methodsexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button testButton;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String greeting = sayHello("Roxanne");




    }



    public static String sayHello(String name){

    String greeting = "Hello " + name +". How are you?";



    //Log.d("char at index", ""+ greeting.contains("Hello"));

    return greeting;
   }



}
