package com.example.nietof.persistentdatatest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button saveBtn;
    private TextView resultView;
    private EditText enterMsgView;
    private static final String MESSAGE_ID = "messages_prefs";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveBtn = findViewById(R.id.saveBtn);
        resultView = findViewById(R.id.resultTextView);
        enterMsgView = findViewById(R.id.myEditText);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg = enterMsgView.getText().toString().trim();

                SharedPreferences shardPrefs = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);

                SharedPreferences.Editor editor = shardPrefs.edit();

                editor.putString("message", msg);

                editor.apply(); //write to disk.




            }
        });


        SharedPreferences getShareData = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);

        String value = getShareData.getString("message" , "data unavailable");

        resultView.setText(value);




    }
}
