package com.example.nietof.quizapp;

public class Question {


    private int answerResID;
    private boolean isCorrect;

    public Question(int answerResID, boolean isCorrect) {
        this.answerResID = answerResID;
        this.isCorrect = isCorrect;
    }

    public int getAnswerResID() {
        return answerResID;
    }

    public void setAnswerResID(int answerResID) {
        this.answerResID = answerResID;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
