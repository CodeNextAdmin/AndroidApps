package com.example.nietof.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button falseBtn;
    private Button trueBtn;
    private TextView questionTextView;
    private Button nextQuestionBtn;

    private  int questionCounter =0 ;

    private Question[] questions = new Question[]{

            new Question(R.string.q1, true),
           new Question(R.string.q2, false),
            new Question(R.string.q3, false),
            new Question(R.string.q4, true),
            new Question(R.string.q5, false),
            new Question(R.string.q6, true),
            new Question(R.string.q7, false),
            new Question(R.string.q8, true)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        trueBtn = findViewById(R.id.true_btn);
        questionTextView = findViewById(R.id.answer_text_view);
        falseBtn = findViewById(R.id.false_btn);
        nextQuestionBtn = findViewById(R.id.next_question_btn);


        falseBtn.setOnClickListener(this);
        trueBtn.setOnClickListener(this);
        nextQuestionBtn.setOnClickListener(this);




    }


    @Override
    public void onClick(View v) {

          boolean isThisQuestionCorrect;

        switch (v.getId()){

            case  R.id.false_btn:


                isThisQuestionCorrect = questions[questionCounter].isCorrect();
                //touching the false button

                if(isThisQuestionCorrect){

                    Toast.makeText(MainActivity.this, "NOPE!", Toast.LENGTH_SHORT).show();
                } else{

                    Toast.makeText(MainActivity.this, "YAY!", Toast.LENGTH_SHORT).show();
                }

                break;

            case  R.id.true_btn:

                 isThisQuestionCorrect = questions[questionCounter].isCorrect();
                //touching the false button

                if(isThisQuestionCorrect){

                    Toast.makeText(MainActivity.this, "Yay!", Toast.LENGTH_SHORT).show();
                } else{

                    Toast.makeText(MainActivity.this, "Nope!", Toast.LENGTH_SHORT).show();
                }


                break;

            case R.id.next_question_btn:

                next();
                break;




        }

    }


    public void next(){



        if(questionCounter < questions.length){


            Log.d("next" , "question counter" + questionCounter);
            questionTextView.setText(questions[questionCounter].getAnswerResID());



        } else {

            questionCounter =0;
            Log.d("next" , "question counter" + questionCounter);
            questionTextView.setText(questions[questionCounter].getAnswerResID());
        }

        questionCounter++;





    }
}
