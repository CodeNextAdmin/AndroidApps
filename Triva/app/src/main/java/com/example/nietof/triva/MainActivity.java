package com.example.nietof.triva;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nietof.triva.data.AnswerListAsyncResponse;
import com.example.nietof.triva.data.QuestionBank;
import com.example.nietof.triva.model.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button trueBtn;
    private Button falseBtn;
    private TextView questionTxt;
    private TextView counterTxt;
    private ImageButton nextBtn;
    private ImageButton prevBtn;
    private boolean isCurrentQuestionTrue;

    private int questionIndex =0;
    private  List<Question> questionList;

    private CardView cardView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueBtn = findViewById(R.id.btn_true);
        falseBtn = findViewById(R.id.btn_false);
        counterTxt = findViewById(R.id.counter_txt);
        questionTxt = findViewById(R.id.question_txt_view);
        nextBtn = findViewById(R.id.btn_next);
        prevBtn = findViewById(R.id.btn_previous);
        cardView = findViewById(R.id.cardView);

        trueBtn.setOnClickListener(this);
        prevBtn.setOnClickListener(this);
        falseBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);




         questionList = new QuestionBank().getQuestions(new AnswerListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Question> questionArrayList) {

                //only here will we get the data

                Log.d("main " , " " + questionArrayList);
                Log.d("main" , "questions are loaded");



                loadFirstQuestion(questionArrayList);

            }
        });



    }

    @Override
    public void onClick(View v) {

        Log.d("onclick ", " " + v.getId());

        switch (v.getId()){

            case R.id.btn_next:

                questionIndex = (questionIndex +1) % questionList.size() ;

                Log.d("index", "" + questionIndex);

                updateQuestion();
                break;

            case R.id.btn_previous:


                Log.d("index", "" + questionIndex);

                 ;
                if( questionIndex > 0){

                    questionIndex = (questionIndex -1) % questionList.size();
                    updateQuestion();


                    }
                break;
            case R.id.btn_false:
                Log.d("onclick", "false" );
                checkAnswer(false);
                break;

            case R.id.btn_true:
                Log.d("onclick", "true" );
                checkAnswer(true);
                break;
        }
    }


    public void loadFirstQuestion(ArrayList<Question> questionsArray){

        Log.d("LoadingQuestion: " , "first: " + questionsArray.get(questionIndex));
        isCurrentQuestionTrue = questionsArray.get(1).isTrue();

        setQuestionTxt(questionsArray.get(questionIndex).getAnswer());
        updateCounter();


    }

    public void setQuestionTxt(String qtext ){


    }

    public void updateQuestion(){

        String question = questionList.get(questionIndex).getAnswer();
        questionTxt.setText(question);
        Log.d("This question is ", "" + questionList.get(questionIndex).isTrue());
        updateCounter();



    }

    private void shakeAnimation(){

        Animation shake = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake_animation);

        cardView.setAnimation(shake);

        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                cardView.setCardBackgroundColor(Color.RED);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                cardView.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void updateCounter(){

        counterTxt.setText(" " + (questionIndex+1) + " / " + questionList.size());

    }

    public void checkAnswer(boolean answerChoice){

        boolean isTrue = questionList.get(questionIndex).isTrue();

        if(answerChoice == isTrue){

            Log.d("answer is: " , "Correct!");


            Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
            fadeView();
        }else  {

            Log.d("answer is: " , "InCorrect :(");
            Toast.makeText(MainActivity.this, "Wrong!!!", Toast.LENGTH_SHORT).show();
            shakeAnimation();
        }
        questionIndex ++;
        updateQuestion();
    }

    public void fadeView(){

        AlphaAnimation fade = new AlphaAnimation(1.0f, 0.0f);

        fade.setDuration(350);
        fade.setRepeatCount(1);
        fade.setRepeatMode(Animation.REVERSE);

        cardView.setAnimation(fade);

        fade.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                cardView.setCardBackgroundColor(Color.GREEN);

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                cardView.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



    }


}
