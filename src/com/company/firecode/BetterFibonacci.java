package com.company.firecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BetterFibonacci {

    public static void main(String[] args) {
        System.out.println(betterFibonacci(2));
        System.out.println(betterFibonacci(3));

        List<Integer>list=new ArrayList<>();
        if(list.get(0)==null){
            System.out.println("yes");
        }else {
            System.out.println("No");
        }


    }
    public static int betterFibonacci(int n) {
        int i, j;
        if (n==0){
            return 0;
        }
        if(n==1  || n ==2){
            return 1;
        }

        i=1; //fib(1)
        j=1; // fib(2)
        //fib(3)=fib(2) + fib(1);
        // fib(4)= fib(3) + fib(2)
        int sum=0;
        for(int k = 3; k<=n; k++){
            sum = i+j;
            i=j;
            j=sum;
        }

        return sum;

    }
}
