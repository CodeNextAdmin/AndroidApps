package com.example.likes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button submitBtn = (Button) findViewById(R.id.btn_submit);
    private EditText inputText = (EditText) findViewById(R.id.input_txt_view);
    private TextView outputText = (TextView) findViewById(R.id.ouput_txt_view);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void displayMessage(View v){

        Log.d("msg:" , "message!");

    }
}
