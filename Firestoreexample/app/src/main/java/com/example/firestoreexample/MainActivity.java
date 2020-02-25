package com.example.firestoreexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users = new ArrayList<String>();

       // addRecord("John", "Coltrane", 1921);
       // addRecord("Lucio", "Nieto", 2004);
       // addRecord("Sabina", "Nieto", 2006);

        getAllRecords();



    }


    public void addRecord(String fn, String ln, int dob){


        Log.d("addRecord", "adding record");


        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> user = new HashMap<>();
        user.put("first", fn);
        user.put("last", ln);
        user.put("born", dob);

        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("onCreate", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("onfailure", "Error adding document", e);
                    }
                });



    }

    public void getAllRecords(){

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("getAllRecords", document.getId() + " => " + document.getData().get("first"));

//                                Map<String, Object> user = new HashMap<>();
//                                user.put("first", document.getData().get("first"));
//                                user.put("last", document.getData().get("last"));

                                String first = document.getData().get("first").toString();

                                users.add(first);

                            }

                            Log.d("getAllRecords" , "users " + users);

                        } else {
                            Log.w("getAllRecords", "Error getting documents.", task.getException());
                        }
                    }
                });



    }




}
