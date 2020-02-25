package com.example.nietof.mypetapp;

public class Monster {

    private int foodValue;
    private int waterValue;
    private int loveValue;


    public Monster(){};
    public Monster(int foodValue, int waterValue, int loveValue) {
        this.foodValue = foodValue;
        this.waterValue = waterValue;
        this.loveValue = loveValue;
    }

    public int getFoodValue() {
        return foodValue;
    }

    public void setFoodValue(int foodValue) {
        this.foodValue = foodValue;
    }

    public int getWaterValue() {
        return waterValue;
    }

    public void setWaterValue(int waterValue) {
        this.waterValue = waterValue;
    }

    public int getLoveValue() {
        return loveValue;
    }

    public void setLoveValue(int loveValue) {
        this.loveValue = loveValue;
    }
}
