package com.company.revision;

public class RevLc1155NumberOfDiceRollsWithTargetSum {

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(1,6,3));
        System.out.println(numRollsToTarget(3,6,8));
        System.out.println(numRollsToTarget(30,30,500));

    }
    public static int numRollsToTarget(int d, int f, int target) {
//        d==>noOfDices
//        f==> noOfFacesForDices
//
        double MOD = 1000000000.0 + 7;
        int maxCol = f > target ? f + 1 : target + 1;
        int [][] dp = new int[d + 1][maxCol];

//        Fill all the first row columns with the no of faces
        for(int i = 1; i <= f; i++){
            dp[1][i]=1;
        }

        for(int i =2; i <= d; i++){
            for (int j = 1; j <= target; j++){
                fillDp(i, j,dp,f,MOD);
            }
        }


        return dp[d][target];
    }

    public static void fillDp(int noOfDice, int target, int [][] dp, int faces, double MOD){
        int boundary = target-faces;
        int sum =0;
        for(int i = target-1; i>=boundary; i--){
            if(i<1)
                break;
            sum += dp[noOfDice - 1][i] % MOD;
            sum %= MOD;

        }
        dp[noOfDice][target]=sum;
    }
}
