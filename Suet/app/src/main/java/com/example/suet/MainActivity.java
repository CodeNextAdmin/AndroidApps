package com.example.suet;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

//import com.example.suet.data.DatabaseQuery;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.google.firebase.firestore.DocumentReference;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;





 import java.util.Map;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener, SensorEventListener {


    private EditText addNewEditTxt;
    private Button addNewBtn;
    private Button recordWOBtn;
    private EditText amtEditTxt;
    private TextView stepsTxt;



    private ArrayList<String> workoutsArray;
    private Spinner spinner;

    private Sensor stepSensor;
    private  SensorManager sManager;



    final FirebaseFirestore db = FirebaseFirestore.getInstance();
    //private FirestoreInterface callbackInterface;

   // private DatabaseQuery dbQuery;


    private long steps = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //add the step sensor
         sManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
         stepSensor = sManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);





       // dbQuery = new DatabaseQuery( );

        workoutsArray = new ArrayList<String>();

        spinner =  findViewById(R.id.workout_spinner);
        spinner.setOnItemSelectedListener(this);
        recordWOBtn = findViewById(R.id.record_workout_btn);
        amtEditTxt = findViewById(R.id.amt_edit_txt);
        stepsTxt = findViewById(R.id.steps_txt_view);


        addNewBtn = findViewById(R.id.save_new_wo_btn);

        addNewBtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {


                    String newWorkout = addNewEditTxt.getText().toString();

                    Log.d("addNewBtn", "onClick: " + newWorkout);

                    //add our new workout

                    Map<String, Object> workoutMap = new HashMap<>();
                    workoutMap.put("type", newWorkout);

                    db.collection("added_workouts")
                            .add(workoutMap)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(getApplicationContext(), "Wokrout added", Toast.LENGTH_LONG).show();
                                    Log.d("addworkout", "added workout success!");

                                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                                    imm.hideSoftInputFromWindow(addNewEditTxt.getWindowToken(), 0);


                                    //set the spinner to display the latest one added

                                    spinner.setSelection(((ArrayAdapter)spinner.getAdapter()).getPosition("type"));

                                    addNewBtn.setVisibility(View.INVISIBLE);
                                    addNewEditTxt.setVisibility(View.INVISIBLE);

                                   //Map workoutsMap = dbQuery.loadWorkouts();



                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    Toast.makeText(getApplicationContext(), "Wokrout failed to add", Toast.LENGTH_LONG).show();
                                    Log.d("addworkout", "added workout Failure:  " + e.getMessage().toString());

                                }
                            });

            }
        });


        addNewEditTxt = findViewById(R.id.new_workout_editTxt);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                if(addNewBtn.getVisibility() == View.VISIBLE) {

                    //button is visible, so hide it.

                    Log.d("onClick", "button is visible");

                    addNewBtn.setVisibility(View.INVISIBLE);
                    addNewEditTxt.setVisibility(View.INVISIBLE);

                } else {

                    addNewBtn.setVisibility(View.VISIBLE);
                    addNewEditTxt.setVisibility(View.VISIBLE);


                }
            }
        });


        loadWorkouts(); //load all the workouts form the Firestore..

        ArrayAdapter<String> workoutAdapter =  new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, workoutsArray );


        recordWOBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String amt = amtEditTxt.getText().toString();


                if(amt.matches("")  ){

                    Toast.makeText(getApplicationContext(), "Please enter an activity amount", Toast.LENGTH_LONG).show();

                } else {

                    String newActivityType = spinner.getSelectedItem().toString();

                    Log.d("recordWOBtn", "recording activity : " + newActivityType );

                    Log.d("recordWOBtn", "amount : " + amtEditTxt.getText() );


                    int newActivityAmount = Integer.parseInt(amtEditTxt.getText().toString()) ;


                    Date activityDate = new Date();
                    String fDate = new SimpleDateFormat("yyyy-MM-dd").format(activityDate);

                    Log.d("recordWOBtn", "recording activity : " + fDate+ " - " + newActivityType + " - " + newActivityAmount);

                    Map<String, Object> activityMap = new HashMap<>();
                    activityMap.put("type", newActivityType);
                    activityMap.put("amount" , newActivityAmount);
                    activityMap.put("date", activityDate);
                    activityMap.put("intensity", "1");


                    db.collection("workout_activity")
                            .add(activityMap)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {

                                    Log.d("onSuccess", "DocumentSnapshot added with ID: " + documentReference.getId());

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    Log.d("onFailure", "Error adding document", e);

                                }
                            });

                    //hide keyboard and notify user
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(amtEditTxt.getWindowToken(), 0);

                    Toast.makeText(getApplicationContext(), "Activity Recorded", Toast.LENGTH_LONG).show();

                }

            }
        });

       // Map workoutsMap = dbQuery.loadWorkouts();
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

            Log.d("menu", "id:  " + id);

            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);

            return true;

        } else if (id == R.id.show_progress){

            Log.d("menu", "id:  " + id);

            Intent intent = new Intent(this, Progress.class);
            startActivity(intent);



            return true;

        }



        return super.onOptionsItemSelected(item);
    }


    public void loadWorkouts(){


        //get the data from Firestore

        //empty the array if not empty

        workoutsArray.clear();

        db.collection("added_workouts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {


                        if(task.isSuccessful()){


                            for (QueryDocumentSnapshot document : task.getResult()) {


                                Map<String, Object> workoutsMap = document.getData();

                                Log.d("loadWorkouts",  "" + workoutsMap.get("type"));

                                workoutsArray.add(workoutsMap.get("type").toString());

                                ArrayAdapter<String>arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, workoutsArray);

                                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                // Apply the adapter to the spinner
                                spinner.setAdapter(arrayAdapter);

                                int iCurrentSelection = spinner.getSelectedItemPosition();

                                Log.d("spinner" , "current selection " + iCurrentSelection);

                                Log.d("workout array", "" + workoutsArray.toString());

                            }


                        }else{

                            Log.w("loadWorkouts", "Error getting documents.", task.getException());

                        }

                        for(String item : workoutsArray){


                            Log.d("item", "item " + item);
                        }

                    }
                });


    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



             String selection = adapterView.getItemAtPosition(i).toString();

                Log.d("onItemSel." , " >>> " + selection);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        Sensor sensor = sensorEvent.sensor;
        float[] values = sensorEvent.values;
        int value = -1;
        if (values.length > 0) {
            value = (int) values[0];
        }
        if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            steps++;

            Log.d("onSensorChanged" , "" + steps);

            stepsTxt.setText(""+steps);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }
    @Override
    protected void onStop() {
        super.onStop();
        sManager.unregisterListener(this, stepSensor);
    }
}
