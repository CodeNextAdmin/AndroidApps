package com.example.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
/*import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;*/

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int pcScore = 0;
    private int playerScore = 0;
    private int round = 0;
    private TextView displayScore;
    private TextView displayText;
    private ImageView pcImage;
    private ImageView playerImage;
    private int images[] = {R.drawable.rock, R.drawable.paper, R.drawable.scissors};

    //Animation
    /*private AnimatorSet mSetRightOut;
    private AnimatorSet mSetLeftIn;
    private boolean mIsBackVisible = false;
    private View mCardFrontLayout;
    private View mCardBackLayout;*/

    //Helpers
    private Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayScore = findViewById(R.id.score);
        displayText = findViewById(R.id.display);
        pcImage = findViewById(R.id.imagePc);
        playerImage = findViewById(R.id.imagePlayer);

        //Animation
        /*findViews();
        loadAnimations();
        changeCameraDistance();*/

    }

    public void play(int player) {
        //flipCard();
        round++;
        //0 = rock, 1 = paper, 2 = scissors
        int pcChoice = random.nextInt(3);
        //int player = 1;
        //0 = loss, 1 = tied, 2 = win
        int outcome;

        switch(pcChoice) {
            case 0:
                pcImage.setImageDrawable(getResources().getDrawable(images[0]));
                switch (player) {
                    case 0:
                        outcome = 1;
                        break;
                    case 1:
                        outcome = 2;
                        break;
                    default:
                        outcome = 0;
                        break;
                }
                break;
            case 1:
                pcImage.setImageDrawable(getResources().getDrawable(images[1]));
                switch (player) {
                    case 0:
                        outcome = 0;
                        break;
                    case 1:
                        outcome = 1;
                        break;
                    default:
                        outcome = 2;
                        break;
                }
                break;
            default:
                pcImage.setImageDrawable(getResources().getDrawable(images[2]));
                switch (player) {
                    case 0:
                        outcome = 2;
                        break;
                    case 1:
                        outcome = 0;
                        break;
                    default:
                        outcome = 1;
                        break;
                }
                break;
        }

        switch(outcome) {
            case 0:
                //player loss
                ++pcScore;
                break;
            case 1:
                //player tie - no score changes
                //++pcScore;
                //++playerScore;
                break;
            default:
                //player win
                ++playerScore;
                break;
        }
        displayText.setText(String.format("Round %d", round));
        displayScore.setText(String.format("%d  -  %d", playerScore, pcScore));
    }

    public void rock(View view) {
        playerImage.setImageDrawable(getResources().getDrawable(images[0]));
        play(0);
    }

    public void paper(View view) {
        playerImage.setImageDrawable(getResources().getDrawable(images[1]));
        play(1);
    }

    public void scissors(View view) {
        playerImage.setImageDrawable(getResources().getDrawable(images[2]));
        play(2);
    }

    public void reset(View view) {
        pcScore = 0;
        playerScore = 0;
        round = 0;
        playerImage.setImageResource(android.R.color.transparent);
        pcImage.setImageResource(android.R.color.transparent);
        displayText.setText(String.format("Ready?"));
        displayScore.setText(String.format("%d  -  %d", playerScore, pcScore));

    }


    //Animation
    /*private void changeCameraDistance() {
        int distance = 8000;
        float scale = getResources().getDisplayMetrics().density * distance;
        mCardFrontLayout.setCameraDistance(scale);
        mCardBackLayout.setCameraDistance(scale);
    }

    private void loadAnimations() {
        mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.out_animation);
        mSetLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.in_animation);
    }

    private void findViews() {
        mCardBackLayout = findViewById(R.id.card_back);
        mCardFrontLayout = findViewById(R.id.card_front);
    }

    public void flipCard() {
        if (!mIsBackVisible) {
            mSetRightOut.setTarget(mCardFrontLayout);
            mSetLeftIn.setTarget(mCardBackLayout);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = true;
        } else {
            mSetRightOut.setTarget(mCardBackLayout);
            mSetLeftIn.setTarget(mCardFrontLayout);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = false;
        }
    }*/
}
