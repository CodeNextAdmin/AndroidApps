package com.example.suet.model;

import java.util.Date;

public class Workout {

    private Date woDate;
    private String woType;
    private int woAmount;
    private int intensity;

    public Workout(Date woDate, String woType, int woAmount, int intensity) {
        this.woDate = woDate;
        this.woType = woType;
        this.woAmount = woAmount;
        this.intensity = intensity;
    }

    public Date getWoDate() {
        return woDate;
    }

    public void setWoDate(Date woDate) {
        this.woDate = woDate;
    }

    public String getWoType() {
        return woType;
    }

    public void setWoType(String woType) {
        this.woType = woType;
    }

    public int getWoAmount() {
        return woAmount;
    }

    public void setWoAmount(int woAmount) {
        this.woAmount = woAmount;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
}
