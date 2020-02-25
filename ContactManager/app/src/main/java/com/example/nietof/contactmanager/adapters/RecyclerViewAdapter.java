package com.example.nietof.contactmanager.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nietof.contactmanager.ContactDetail;
import com.example.nietof.contactmanager.R;
import com.example.nietof.contactmanager.model.Contact;

import java.util.List;

import static com.example.nietof.contactmanager.R.id.contact_name;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Contact> contactList;

    public RecyclerViewAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //create our own view here.
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contact_row, viewGroup, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int pos) {

        Contact contact = contactList.get(pos);

         viewHolder.contactName.setText(contact.getName());
         viewHolder.phoneNumber.setText(contact.getPhone());

         Log.d("adapter", "onBindViewHlder called");



    }



    @Override
    public int getItemCount() {

        Log.d("adapter", "contactList count " + contactList.size());
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView contactName;
        public TextView phoneNumber;


        public ViewHolder(@NonNull View itemView) {


            super(itemView);

            itemView.setOnClickListener(this); //register to listen.

            contactName= itemView.findViewById(R.id.contact_name);
            phoneNumber= itemView.findViewById(R.id.contact_phone);
        }

        @Override
        public void onClick(View v) {



            int pos =  getAdapterPosition(); //returns the index of the row for our adapter
            Contact c = contactList.get(pos);
            Log.d("adapter", "view clicked " + c.getName());



            Intent detailView = new Intent(context, ContactDetail.class); //this is how you launch an new activity

            detailView.putExtra("name", c.getName());
            detailView.putExtra("phone", c.getPhone());


            context.startActivity(detailView);

            //setContentView(R.layout.activity_main);


        }
    }
}
