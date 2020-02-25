package com.example.nietof.addmoney;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private TextView moneyText;

    private int total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_layout);


        moneyText = findViewById(R.id.money_txt);






    }


    public void showTags(View v){

        Log.d("showTags" ,"onClick fired" );
        Toast.makeText(getApplicationContext(), "You touched me!", Toast.LENGTH_SHORT).show();

    }

    public void showMoney(View v){

        Log.d("showMoney" ,"onClick fired" );

        total +=1000;





        switch(total){


            case 2000:  moneyText.setTextColor(getResources().getColor(R.color.myGreen));

            break;

            case 5000: moneyText.setTextColor(Color.MAGENTA);

            break;

            case 10000: moneyText.setTextColor(Color.CYAN);

            break;

            default:
                break;
        }


        moneyText.setText(String.valueOf(total));

    }

}
