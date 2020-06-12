package com.company.ExecutiveFramework;

import java.util.*;

public class Mortgage {
    public static void main(String[] args) {

        double principal =  getUserInput("Principal", 1, 1000000);
        float rate = (float) getUserInput("Annual Interest Rate", 1, 30);
        int year = (int) getUserInput("period(year)", 1, 30);


        System.out.println("principal = "+principal);
        System.out.println("rate = "+rate);
        System.out.println("year = "+year);

        double mortgage = calculateMortage(principal, rate, year);
        System.out.println("mortgage = "+String.format("%.2f", mortgage));

    }

    public static double getUserInput(String dispaly, int min, int max){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter " + dispaly+": ");
        double userInput = input.nextDouble();
        while (userInput < min && userInput > max){
            System.out.print("Enter " + dispaly);
            userInput = input.nextInt();
        }

        return userInput;
    }

    public static double calculateMortage(double principal, float rate, int year){
        double r = rate / 1200;
        int n  = year * 12;
        double calculatex= (1+r);
        calculatex= Math.pow(calculatex,n);
        double numerator = r * calculatex;
        double denumenator = calculatex - 1;
        double mortgage = principal*(numerator/denumenator);

        return mortgage;
    }
}
