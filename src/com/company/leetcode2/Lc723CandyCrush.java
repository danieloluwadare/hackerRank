package com.company.leetcode2;

import java.util.Arrays;

/**
 * This question is about implementing a basic elimination algorithm for Candy Crush.
 *
 * Given a 2D integer array board representing the grid of candy, different positive integers board[i][j] represent different types of candies. A value of board[i][j] = 0 represents that the cell at position (i, j) is empty. The given board represents the state of the game following the player's move. Now, you need to restore the board to a stable state by crushing candies according to the following rules:
 *
 * If three or more candies of the same type are adjacent vertically or horizontally, "crush" them all at the
 * same time - these positions become empty.
 * After crushing all candies simultaneously, if an empty space on the board has candies on top of itself,
 * then these candies will drop until they hit a candy or bottom at the same time. (No new candies will drop
 * outside the top boundary.)
 * After the above steps, there may exist more candies that can be crushed. If so, you need to repeat the
 * above steps.
 * If there does not exist more candies that can be crushed (ie. the board is stable), then return the
 * current board.
 * You need to perform the above rules until the board becomes stable, then return the current board.
 *
 * Input:
 * board =
 * [[110,5,112,113,114],[210,211,5,213,214],[310,311,3,313,314],[410,411,412,5,414],[5,1,512,3,3],
 * [610,4,1,613,614],[710,1,2,713,714],[810,1,2,1,1],[1,1,2,2,2],[4,1,4,4,1014]]
 *
 * Output:
 * [[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[110,0,0,0,114],[210,0,0,0,214],[310,0,0,113,314],
 * [410,0,0,213,414],[610,211,112,313,614],[710,311,412,613,714],[810,411,512,713,1014]]
 *
 * Explanation:
 *
 *
 *
 * Note:
 *
 * The length of board will be in the range [3, 50].
 * The length of board[i] will be in the range [3, 50].
 * Each board[i][j] will initially start as an integer in the range [1, 2000].
 *
 */
public class Lc723CandyCrush {
    public static void main(String[] args) {
        int [][] board ={
                {110,5,112,113,114},
                {210,211,5,213,214},
                {310,311,3,313,314},
                {410,411,412,5,414},
                {5,1,512,3,3},
                {610,4,1,613,614},
                {710,1,2,713,714},
                {810,1,2,1,1},
                {1,1,2,2,2},
                {4,1,4,4,1014}
        };
        candyCrush(board);
//        System.out.println(Ar);
    }

    public static int[][] candyCrush(int[][] board) {

        boolean reVisit= true;
        while (reVisit){
            reVisit=false;
//            horizontal check
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[i].length-2; j++){
                    if(board[i][j] != 0
                            && Math.abs(board[i][j]) == Math.abs(board[i][j+1])
                            && Math.abs(board[i][j+1])==Math.abs(board[i][j+2])){
                        reVisit=true;
                        for (int k = 0; k < 3; k++){
                            if(board[i][j + k] > 0)
                                board[i][j + k] = -1 * board[i][j + k];
                        }
                    }
                }
            }
//            vertical check
            for (int i = 0; i < board[0].length; i++){
                for (int j = 0; j < board.length - 2; j++){
                    if(board[j][i] != 0
                            && (Math.abs(board[j][i]) == Math.abs(board[j + 1][i]))
                            && (Math.abs(board[j + 1][i]) == Math.abs(board[j + 2][i]))) {
                        reVisit=true;
                        for (int k = 0; k < 3; k++){
                            if(board[j + k][i] > 0)
                                board[j + k][i] = -1 * board[j + k][i];
                        }
                    }
                }
            }

            for(int i = 0; i < board[0].length; i++){
                int k = board.length-1;
                for (int j = board.length-1; j >= 0; j--){
                    if(board[j][i] > 0){
                        int temp = board[j][i];
                        board[j][i] = board[k][i];
                        board[k][i] = temp ;
                        k--;
                    }
                }


//                convert all the remain values from k to zero since they will contain some
//                 negative numbers which could cause an infinite loop
                for(int l = k;  l >= 0; l--){
                    board[l][i]=0;
                }
            }

        }

        System.out.println("final array");
        for (int [] i : board){
            System.out.println(Arrays.toString(i));
            System.out.println();;
        }

        return board;
    }
}
