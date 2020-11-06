package com.company.firecode;

import java.util.Arrays;

public class Cell {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new int[]{0,1,0,0,0,0,1,0}));
        System.out.println(cellCompete(new int[]{0,1,0,0,0,0,1,0}, 9));
    }

    public static int[] cellCompete(int[] cells, int days)
    {
        int oldCell[]=new int[cells.length];

        for (Integer i = 0; i < cells.length ; i++ ){
            oldCell[i] = cells[i];
        }
        for (Integer k = 0; k < days ; k++ ){
            System.out.println(k);
//            index
            for (Integer j = 1; j < oldCell.length - 1 ; j++ ){
                if ((oldCell[j-1] == 1 && oldCell[j+1] == 1) || (oldCell[j-1] == 0 && oldCell[j+1] == 0)){
                    cells[j] = 0;
                } else{
                    cells[j] = 1;
                }
            }
                cells[0] = oldCell[1];
                cells[7] = oldCell[7-1];
            System.out.println(Arrays.toString(cells));

            for (Integer i = 0; i < cells.length ; i++ ){
                oldCell[i] = cells[i];
            }
        }
        return cells;
    }
}
