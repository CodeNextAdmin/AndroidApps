package com.example.myapplication;

public class Girl {

    private int id ;
    private int score;

    public Girl(int id, int score) {
        this.id = id;
        this.score = score;
    }

    public Girl() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
