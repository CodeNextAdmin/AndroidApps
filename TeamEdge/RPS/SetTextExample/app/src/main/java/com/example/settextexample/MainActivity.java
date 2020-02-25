package com.example.settextexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button submitBtn;
    private TextView outputTextView;
    private EditText enterTextView;
    private String messages ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        submitBtn = findViewById(R.id.sumbitBtn);
        outputTextView = findViewById(R.id.outputText);
        enterTextView = findViewById(R.id.enterText);

        enterTextView.getText().clear();
        outputTextView.setText("messages output here");



        String hello = "Hello";

        Log.d("string contains Hi ", ""+ hello.contains("Hi"));
        Log.d("string contains He ", "" + hello.contains("He"));



        String buttonText = submitBtn.getText().toString();


        Log.d("button ID ", "" + buttonText);
















    }

    public void displayMessages(View v){

        String newMessage = enterTextView.getText().toString() + "\n";
        enterTextView.getText().clear();

        outputTextView.setText("");

        messages = messages + newMessage;





        outputTextView.append(messages);




    }
}
