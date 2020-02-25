package com.example.nietof.newproject;

import java.util.Scanner;


import android.util.Log;

public class MyClass {



    public static void main(String[] args) {


        System.out.println("Let's play. choose rock, paper or scissors...");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        System.out.println("You chose: ");
        System.out.println(choice);

        int firstInt = 5;
        int secondInt = 2;
        int sum = firstInt + secondInt;


    }
}


