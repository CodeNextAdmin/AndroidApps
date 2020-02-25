package com.example.xrcise.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.xrcise.model.Workout;
import com.example.xrcise.util.Constants;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

    private final Context context;

    public DatabaseHandler(@Nullable Context context) {
        super(context, Constants.DB_NAME, null  , Constants.DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_DB_TABLE = "CREATE TABLE " + Constants.TABLE_NAME + "("
                + Constants.KEY_ID + " INTEGER PRIMARY KEY,"
                + Constants.KEY_TYPE+ " TEXT,"
                + Constants.KEY_AMOUT+ " INTEGER,"
                + Constants.KEY_DATE+ " LONG);";


        db.execSQL(CREATE_DB_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

         db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
         onCreate(db);

    }

    public void addWorkout(Workout workout){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constants.KEY_TYPE, workout.getWorkoutType());
        values.put(Constants.KEY_AMOUT, workout.getWorkoutAmout());
        values.put(Constants.KEY_DATE, java.lang.System.currentTimeMillis());

        db.insert(Constants.TABLE_NAME, null, values);
        Log.d("dbHandler", "added workout");


    }

    public Workout getWorkout(int id){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Constants.TABLE_NAME,
                new String[]{ Constants.KEY_ID, Constants.KEY_TYPE, Constants.KEY_AMOUT, Constants.KEY_DATE },
                    Constants.KEY_ID+ "=?",
                new String[] { String.valueOf(id)}, null, null, null, null );

        if(cursor!=null){

            cursor.moveToFirst();
        }

        Workout workout = new Workout();
        workout.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.KEY_ID))));
        workout.setWorkoutType(cursor.getString(cursor.getColumnIndex(Constants.KEY_TYPE)));
        workout.setWorkoutAmout(cursor.getInt(cursor.getColumnIndex(Constants.KEY_AMOUT)));

        //get readable timestamp
        DateFormat dateFormat = DateFormat.getDateInstance();
        String formattedDate  = dateFormat.format(new Date(cursor.getLong(cursor.getColumnIndex(Constants.KEY_DATE)))
                .getTime() );


        workout.setWorkoutDate(formattedDate);

        return workout;

    }

    public List<Workout> getAllWorkouts(){

        SQLiteDatabase db = this.getReadableDatabase();

        List<Workout> workoutList = new ArrayList<>();

        Cursor cursor = db.query(Constants.TABLE_NAME,
                new String[]{ Constants.KEY_ID, Constants.KEY_TYPE, Constants.KEY_AMOUT, Constants.KEY_DATE },
                null, null, null, null, Constants.KEY_DATE + " DESC", null );


        if(cursor.moveToFirst()){


            do{

                Workout workout = new Workout();
                workout.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.KEY_ID))));
                workout.setWorkoutType(cursor.getString(cursor.getColumnIndex(Constants.KEY_TYPE)));
                workout.setWorkoutAmout(cursor.getInt(cursor.getColumnIndex(Constants.KEY_AMOUT)));

                //get readable timestamp
                DateFormat dateFormat = DateFormat.getDateInstance();
                String formattedDate  = dateFormat.format(new Date(cursor.getLong(cursor.getColumnIndex(Constants.KEY_DATE)))
                        .getTime() );


                workout.setWorkoutDate(formattedDate);

                workoutList.add(workout);

            }while (cursor.moveToNext());

        }


        return workoutList;
    }


    public int updateWorkout(Workout workout){


        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constants.KEY_TYPE, workout.getWorkoutType());
        values.put(Constants.KEY_AMOUT, workout.getWorkoutAmout());
        values.put(Constants.KEY_DATE, java.lang.System.currentTimeMillis());

        return db.update(Constants.TABLE_NAME, values, Constants.KEY_ID + "=?", new String[]{String.valueOf(workout.getId())});
    }

    public void deleteWorkout(int id){

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(Constants.TABLE_NAME, Constants.KEY_ID+ "=?",
                new String[]{String.valueOf(id)});

        db.close();

    }

    public int getItemCount(){

        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + Constants.TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);

        return cursor.getCount();
    }
}
