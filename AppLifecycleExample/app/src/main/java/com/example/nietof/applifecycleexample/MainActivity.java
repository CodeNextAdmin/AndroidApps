package com.example.nietof.applifecycleexample;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity {


    private Button showGuessBtn;
    private TextView enterTextView;
    private final int REQUEST_CODE = 2;
    private RequestQueue requestQ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showGuessBtn = findViewById(R.id.button_guess);
        enterTextView = findViewById(R.id.enter_txt);


        requestQ = Volley.newRequestQueue(this);

        String url = "https://jsonplaceholder.typicode.com/todos/1";
        String url2 = "https://jsonplaceholder.typicode.com/todos";

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    Log.d("onResponse ", " " + response.getString("title"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("onResponseError ", " " + error.getMessage());

            }
        });


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                Log.d("jsonArray: " , "onResponse: " + response);

                for(int i = 0 ; i < response.length(); i++){

                    try {
                        JSONObject jobj = response.getJSONObject(i) ;



                        Log.d("jsobj" , " "+jobj.getString("title"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onResponse ", " " + error.getMessage());
            }
        });



        requestQ.add(jsonArrayRequest); //sends request





        showGuessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("onCreate", "onclick called");





                String textToPass = enterTextView.getText().toString().trim();

                if(!textToPass.isEmpty()){
                    Intent intent = new Intent(MainActivity.this, ShowGuess.class);
                    intent.putExtra("name",textToPass);
                    //startActivity(intent);
                    startActivityForResult(intent, REQUEST_CODE);

                } else {

                    Toast.makeText(MainActivity.this, "You must enter a name" , Toast.LENGTH_SHORT).show();
                }


            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE ){

            String result = data.getStringExtra("reply");
            Log.d("onActivityResult", " " + result);
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
