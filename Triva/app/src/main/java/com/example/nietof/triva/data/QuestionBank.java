package com.example.nietof.triva.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.nietof.triva.controller.AppController;
import com.example.nietof.triva.model.Question;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    ArrayList<Question> questionArrayList = new ArrayList<>();

    private String url = "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";

    public List<Question> getQuestions(final AnswerListAsyncResponse callback){


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,  url, (JSONArray) null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {



                        for (int i = 0 ; i<response.length(); i++){

                            try {

                               // Log.d("response: ", " "+ response.getJSONArray(i).get(0) );

                                Question question = new Question();

                                question.setAnswer(response.getJSONArray(i).get(0).toString());
                                question.setTrue(response.getJSONArray(i).getBoolean(1));

                                questionArrayList.add(question);




                            } catch (JSONException e) {
                                e.printStackTrace();
                            }



                        }


                        if(null != callback ) callback.processFinished(questionArrayList);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("jsonArrayRequest Error" , " " + error.getMessage() );

            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        return questionArrayList;
    }
}
