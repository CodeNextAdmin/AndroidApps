package com.example.volleydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Random;


public class MainActivity extends AppCompatActivity {


    RequestQueue requestQueue;  //STEP 1
    private TextView dataTextView;
    String data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataTextView = findViewById(R.id.data_txt_view);

        Log.d("onCreate" , "Application loading");

        final int min = 1;
        final int max = 20;
        final int random = new Random().nextInt((max - min) + 1) + min;


        requestQueue = Volley.newRequestQueue(this); //STEP 2

        String url = "https://swapi.co/api/people/"+random+"1/?format=json";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.d("response", " " + response );

                        try{

                            data = response.getString("name");

                            Log.d("data", "Name : " + data);

                            dataTextView.setText(data.toString());

                        }catch (JSONException e){
                            e.printStackTrace();

                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e("response" , "error: " + error);
                    }
                });


         requestQueue.add(jsonObjectRequest);


    }


    //TODO Write a method that takes in a url and a key from the API and returns a value


    public void fetchData(String url, String key){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {


                        Log.e("response" , ""+ response);



                        try{

                            data = response.getString("name");

                            Log.d("data", "Name : " + data);

                            dataTextView.setText(data.toString());


                        }catch(JSONException e){

                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Log.e("response" , "error: " + error);
                    }
                }

        );

    }


}
