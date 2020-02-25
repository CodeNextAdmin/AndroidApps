package com.example.xrcise.model;

import java.util.Date;

public class Workout {

    private  int id;
    private String workoutType;
    private int workoutAmount;
    private String  workoutDate;


    public Workout(int id, String workoutType, int workoutAmount, String workoutDate) {
        this.id = id;
        this.workoutType = workoutType;
        this.workoutAmount = workoutAmount;
        this.workoutDate = workoutDate;
    }

    public Workout(String workoutType, int workoutAmount, String workoutDate) {
        this.workoutType = workoutType;
        this.workoutAmount = workoutAmount;
        this.workoutDate = workoutDate;
    }

    public String getWorkoutDate() {
        return workoutDate;
    }

    public Workout() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    public int getWorkoutAmout() {
        return workoutAmount;
    }

    public void setWorkoutAmout(int workoutAmout) {
        this.workoutAmount = workoutAmout;
    }



    public void setWorkoutDate(String workoutDate) {
        this.workoutDate = workoutDate;
    }
}
