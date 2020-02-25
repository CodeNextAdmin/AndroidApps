package com.example.nietof.triva.model;

public class Question {

    private String answer;
    private boolean isTrue;

    public Question() {

    }

    public Question(String answer, boolean isTrue) {
        this.answer = answer;
        this.isTrue = isTrue;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    @Override
    public String toString() {
        return "Question{" +
                "answer='" + answer + '\'' +
                ", isTrue=" + isTrue +
                '}';
    }
}
