package com.company.leetcode2;

import java.util.Arrays;

public class Lc881MedBoatsToSavePeople {
    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{1,2},  3));
        System.out.println(numRescueBoats(new int[]{3,2,2,1},  3));
        System.out.println(numRescueBoats(new int[]{3,5,3,4},  5));
        System.out.println(numRescueBoats(new int[]{3,1,7},  7));

    }
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);//1 3 7
        int leftIndex = 0;
        int rightIndex = people.length-1;
        int numOfBoat = 0;
        while(leftIndex <= rightIndex){
            numOfBoat++;

            int weightOfPerson1 = people[leftIndex];
            int weightOfPerson2 = people[rightIndex];
            if(weightOfPerson1 + weightOfPerson2 <= limit)
                leftIndex++;

            rightIndex--;

        }
        return numOfBoat;
    }
}
