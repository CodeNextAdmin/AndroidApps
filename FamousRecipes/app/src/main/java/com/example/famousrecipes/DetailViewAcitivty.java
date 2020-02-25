package com.example.famousrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailViewAcitivty extends AppCompatActivity {

    private TextView detailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view_acitivty);


        detailTextView =findViewById(R.id.textView);

        Bundle pageTwoBundle = getIntent().getExtras();

        String pageTwoData = pageTwoBundle.getString("data");

        Log.d("onCreate", pageTwoData);

        detailTextView.setText(pageTwoData);




    }
}
