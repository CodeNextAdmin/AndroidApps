package com.example.suet.data;

import android.util.Log;

import com.example.suet.FirestoreInterface;
import com.example.suet.model.Workout;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;

public class DatabaseQuery {

    FirestoreInterface callback =  null;

    //constructor

    public DatabaseQuery(FirestoreInterface callback) {
        this.callback = callback;
        Log.d("db query constructor", "callback added");
    }


    final FirebaseFirestore db = FirebaseFirestore.getInstance();

    public Map<String, Workout> loadWorkouts(){


        //get the data from Firestore

        Map<String, Workout> workoutMap = new HashMap<>();

        //empty the array if not empty

       // workoutsArray.clear();

        db.collection("added_workouts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {


                        if(task.isSuccessful()){


                            for (QueryDocumentSnapshot document : task.getResult()) {


                                Map<String, Object> workoutsMap = document.getData();

                                Log.d("loadWorkouts",  "" + workoutsMap.get("type"));





                               // workoutsArray.add(workoutsMap.get("type").toString());

                              //  ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, workoutsArray);

                              //  arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                // Apply the adapter to the spinner
                               // spinner.setAdapter(arrayAdapter);


                              //  int iCurrentSelection = spinner.getSelectedItemPosition();

                            //    Log.d("spinner" , "current selection " + iCurrentSelection);


                              //  Log.d("workout array", "" + workoutsArray.toString());

                            }


                        }else{

                            Log.w("loadWorkouts", "Error getting documents.", task.getException());

                        }


                        if(callback != null){

                            callback.updateSpinner();

                        } else {

                            Log.d("callback", "is null!!!");
                        }



                    }
                });

        return workoutMap;


    }


}
