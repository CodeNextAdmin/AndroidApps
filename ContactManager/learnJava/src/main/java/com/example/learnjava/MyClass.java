package com.example.learnjava;
import java.util.Random;

public class MyClass {

    public static void main(String[] args) {


//        int min = 400;
//        int max = 10000;
//
//        int range = (max - min) + 1;
//
//        int randomInt = (int)(Math.random() * range) + min;
//
//        System.out.println("Random " + randomInt);
//
//        // create the Random object
//        Random randomNum = new Random();
//
//        // use the nextInt() method
//        System.out.println("Random between 0 and 500: " + randomNum.nextInt(500));

        int min = 3;
        int max = 7;
        Random rand = new Random();
        int randomInt = rand.nextInt((max - min) + 1) + min;

        System.out.println("Random int : " + randomInt);



    }
}
