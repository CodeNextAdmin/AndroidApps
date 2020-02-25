package com.example.nietof.contactmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.nietof.contactmanager.adapters.RecyclerViewAdapter;
import com.example.nietof.contactmanager.data.DatabaseHandler;
import com.example.nietof.contactmanager.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   // private Button newButton;

    private RecyclerView recycleView;
    private RecyclerViewAdapter recyclerViewAdapter;

    private ArrayList<Contact> contactsArrayList;
    private ArrayAdapter<String> arrayAdapter;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create a database
        db = new DatabaseHandler(MainActivity.this);

        //this List object will hold the data from the DB, not the views for the rows of our rec. view.
        List<Contact> contactList = new ArrayList<>();
       // createContacts();
        contactList = db.getAllContacts();

        //this arrayList is for the recyclerView to show each view as a row
        contactsArrayList = new ArrayList<>();

        //add all the existing contacts to the arrayList
        for(Contact c: contactList ){

            Log.d("contact", ""+ c.getName());

            contactsArrayList.add(c);
        }

        Log.d("Main", "total Count " + db.getCount());

        //create our recyclerView
        recycleView = findViewById(R.id.recview);
        recycleView.setHasFixedSize(true); //??
        recycleView.setLayoutManager(new LinearLayoutManager(this));

        //set up adapter

        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactsArrayList );
        recycleView.setAdapter(recyclerViewAdapter);









        //Contact testContact =   db.getContact();

       // testContact.setName("Sabina Nieto");
       // testContact.setPhone("562-4245");

       // int new_id = db.updateContact(testContact);

       // db.deleteContact(testContact);





    }


    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }

    public void createContacts(){

        db.getAllContacts();

//        Contact newcontact = new Contact();
//
//        newcontact.setPhone("510-555-2222");
//        newcontact.setName("Leo Quinn");

        db.addContact(new Contact("Mario", "456-5555"));
        db.addContact(new Contact("Dry Bones", "34343343"));
        db.addContact(new Contact("Villager", "565768789"));
        db.addContact(new Contact("Luigi", "7833434"));
        db.addContact(new Contact("Pikachu", "10239475"));
        db.addContact(new Contact("Young Link", "2i85676443"));
        db.addContact(new Contact("Charzard", "3435646557"));
    }
}
