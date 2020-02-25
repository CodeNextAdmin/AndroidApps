package com.example.xrcise;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

import com.example.xrcise.data.DatabaseHandler;
import com.example.xrcise.model.Workout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private Button saveBtn;

    private EditText enterAmt;
    private Spinner spinner;
    private DatabaseHandler dbHandler;

    private String newActivityType;





    String[] activityType = { "Push Ups", "Sit Ups", "Curls", "Bike", "Run" };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbHandler = new DatabaseHandler(this);

        List<Workout> allItems = dbHandler.getAllWorkouts();

        for(Workout wo : allItems){

            Log.d("main", "workout: " + wo.getWorkoutType() + " recorded on " + wo.getWorkoutDate());
        }


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {


                  createPopup();


//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();




            }
        });
    }

    private void createPopup() {

        builder = new AlertDialog.Builder(this);

        //inflate popup xml
        View view = getLayoutInflater().inflate(R.layout.popup, null);

        enterAmt = view.findViewById(R.id.amount_edit_text);


        saveBtn = view.findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(newActivityType!=null &&
                    !enterAmt.getText().toString().isEmpty()){


                saveWorkout(v);

                }else {

                    Snackbar.make(v, "please enter an activity and an amount", Snackbar.LENGTH_SHORT).show();
                }



            }
        });

        Spinner spin;
        spin = (Spinner) view.findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item , activityType);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);

        //invoke the builder
        builder.setView(view);

        //invoke dialog class
        dialog = builder.create();
        dialog.show();


    }


    public void saveWorkout(View view){

        Log.d("Main", "workout Saved!");

        Workout workout = new Workout();



        int amount =  Integer.parseInt(enterAmt.getText().toString().trim());

        workout.setWorkoutType(newActivityType);
        workout.setWorkoutAmout(amount);

        dbHandler.addWorkout(workout);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //Do something here after 3 seconds (3000 milliseconds)
                dialog.dismiss();

                //start the new activity
                startActivity(new Intent(MainActivity.this, ListActivity.class));

            }
        }, 2000);

        Snackbar.make(view, "Item Saved!", Snackbar.LENGTH_LONG).show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        newActivityType = activityType[position];
        Log.d("Here", "Selected item: "+activityType[position]);
        Toast.makeText(getApplicationContext(), "Selected item: "+activityType[position] ,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
