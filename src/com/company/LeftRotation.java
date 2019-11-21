package com.company;

public class LeftRotation {

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5};
        int d=4;
        leftRotate(array,d);

    }

    private static void leftRotate(int a[], int d){
        for(int i=0; i<d; i++){
            int arrayOfindexZero=a[0];
            for(int j=0; j<a.length-1; j++){
                a[j]=a[j+1];
            }

            a[a.length-1]=arrayOfindexZero;
        }

        System.out.println(a.length);

        for(int i=0; i<a.length;i++){
            System.out.println(a[i]);
        }

//        for(int i:a){
//            System.out.println(i);
//        }
    }
}
