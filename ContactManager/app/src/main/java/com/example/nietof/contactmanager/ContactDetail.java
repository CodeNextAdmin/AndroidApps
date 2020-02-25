package com.example.nietof.contactmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ContactDetail extends AppCompatActivity {


    private TextView contact_detail_phone;
    private TextView contact_detail_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        contact_detail_name = findViewById(R.id.deetsName);
        contact_detail_phone = findViewById(R.id.deetsPhone);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){

            String name = bundle.getString("name");
            String phone = bundle.getString("phone");

            contact_detail_phone.setText(phone);
            contact_detail_name.setText(name);
        }


    }
}
