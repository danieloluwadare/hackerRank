package com.company.leetcode;

public class Lc1155NumberOfDiceRollsWithTargetSum {

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(1,6,3));
        System.out.println(numRollsToTarget(3,6,8));
        System.out.println(numRollsToTarget(30,30,500));

    }
    public static int numRollsToTarget(int d, int f, int target) {
//        Daniel's Solution
        //no of dices e.g 3 dices
        // no of faces e.g 6 faces
        // the target  e.g target ==8
        double MOD = 1000000000.0 + 7;
        int max = (f>target) ? f+1 :target +1;
        int [][] dp = new int [d+1][max];

//        initialize the targets for when the dice is 1
//        starting from when face is 1 cause if face is zero
//        there is no target and the only sum that are attainable for the 1 dice  is from
//        1 - f where f is the number of face

        for(int i = 1; i <=f; i++){
            dp[1][i]++;
        }

        for(int i = 2; i <=d; i++){
            for(int j=1; j <= target; j++ ){
                getTarget(i, j, f, dp,MOD);
//                dp[i][j]%=MOD;
            }
        }

        return dp[d][target];
    }

    public static void getTarget(int dice, int target, int face, int [][] dp, double MOD){
        int boundary =  target - face;
        for(int i = target-1; i >= boundary; i--){
            if(i<1){
                break;
            }
            dp[dice][target] += (dp[dice-1][i] % MOD);
            dp[dice][target] %= MOD;
        }
    }

    public static void setTarget(int dice, int target, int face, int [][] dp, double MOD){
        for(int i = 1; i <= face; i++){
            if(i > target){
                break;
            }
            dp[dice][target] += (dp[dice-1][target-i] % MOD);
            dp[dice][target] %= MOD;
        }
    }
}
