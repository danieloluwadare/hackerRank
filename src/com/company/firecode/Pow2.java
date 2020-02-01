package com.company.firecode;

public class Pow2 {

    public static void main(String[] args) {
        System.out.println(pow(2, -1));
        System.out.println(pow(2, 2));
        System.out.println(pow(3, -1));
        System.out.println(pow(3, -2));



    }

    public static double pow(double x, int n) {
        if(n==0)return 1;
        if(n==1)return x;
        if(n<0){
            x= (double)1/x;
            if(n > 1){
                x = x * -1;
            }
            n = n * -1;
        }

        double sum = x * pow(x, n-1);
        return sum;
    }
}
