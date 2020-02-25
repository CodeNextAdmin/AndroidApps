package com.example.nietof.contactmanager.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;


import com.example.nietof.contactmanager.R;
import com.example.nietof.contactmanager.model.Contact;
import com.example.nietof.contactmanager.util.Util;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {


    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //create the db

        String CREATE_TABLE= "CREATE TABLE " + Util.TABLE + "("
                +Util.KEY_ID+ " INTEGER PRIMARY KEY, " + Util.KEY_NAME + " TEXT,"
                +Util.KEY_PHONE + " TEXT" + ")";

        db.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //on upgrade, clear the table

        String DROP_TABLE = String.valueOf(R.string.db_drop);


        db.execSQL(DROP_TABLE, new String[]{Util.DATABASE_NAME});

    }


    public void addContact(Contact contact){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, contact.getName());
        values.put(Util.KEY_PHONE, contact.getPhone());

        db.insert(Util.TABLE, null, values);
        db.close();


    }

    public Contact getContact(int id){

        SQLiteDatabase db = this.getReadableDatabase();

        String[] values ={Util.KEY_ID, Util.KEY_NAME, Util.KEY_PHONE};
        String[] contactID = {String.valueOf(id)};


        Cursor cursor = db.query(Util.TABLE, values, Util.KEY_ID +"=?",contactID,
        null,null,null);

        if (cursor !=null){

            cursor.moveToFirst();
            Contact contact = new Contact();
            contact.setId(Integer.valueOf(cursor.getString(0)));
            contact.setName(cursor.getString(1));
            contact.setPhone(cursor.getString(2));

            return contact;

        }

        return null;

    }








    public List<Contact> getAllContacts(){

        SQLiteDatabase db = this.getReadableDatabase();

        List<Contact> contactList = new ArrayList<>();

        String selectAll = "SELECT * FROM " + Util.TABLE ;

        Cursor cursor  = db.rawQuery(selectAll, null);

        if (cursor.moveToFirst()){

            do{

                Contact contact = new Contact();

                contact.setId(Integer.valueOf(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhone(cursor.getString(2));

                contactList.add(contact);


            } while (cursor.moveToNext());
        }

        return contactList;


    }


    public int updateContact(Contact contact){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, contact.getName());
        values.put(Util.KEY_PHONE, contact.getPhone());

        String[] id = new String[]{String.valueOf(contact.getId())};

        return db.update(Util.TABLE, values, Util.KEY_ID + "=?", id );
    }

    public void deleteContact(Contact contact){

        SQLiteDatabase db = this.getWritableDatabase();

        String[] id = new String[]{String.valueOf(contact.getId())};

        db.delete(Util.TABLE, Util.KEY_ID+"=?", id);

        db.close();

    }

    public int getCount(){
        String countQuery = "SELECT * FROM " + Util.TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();


    }


}
