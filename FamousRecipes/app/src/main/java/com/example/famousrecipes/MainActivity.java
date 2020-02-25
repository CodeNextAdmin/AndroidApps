package com.example.famousrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.imageButton);

    }


    public void showDetail(View view) {

        Log.d("showDetail", "showing detail" );

        Intent pageTwoIntent = new Intent(this, DetailViewAcitivty.class);
        String data = "Happy Day after your Birthday";
        String name = "Donna";
        pageTwoIntent.putExtra("data", data);
        pageTwoIntent.putExtra("name", name);



        startActivity(pageTwoIntent);

    }
}
