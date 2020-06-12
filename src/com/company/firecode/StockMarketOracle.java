package com.company.firecode;

public class StockMarketOracle {

    public static void main(String[] args) {
        int [] arr = {0,50,10,100,30};
        int [] arr1 = {100,100,80,20};
        int [] arr3 = {0,100,123,0,100,0,100};

//        System.out.println(maxProfit(arr));
//        System.out.println(maxProfit2(arr3));

        System.out.println("000016200102135311522CDCI".substring(0,"000016200102135311522CDCI".length()-4));

    }

    public static int maxProfit(int[] a) {
        int localMinima= 0;
        int localmaxima = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int sumOfProfit = 0;

        while (i<a.length){
            if(i<=a.length-2 && j< a.length && a[i]<a[i+1]){
                localMinima=a[i];
                j=i+1;

                while(j<a.length){
                    int currentNumber  = a[j];
                    if(currentNumber > localmaxima){
                        localmaxima=currentNumber;
                        j++;
                        if(j >= a.length){
                            sumOfProfit=sumOfProfit+(localmaxima-localMinima);
                        }
                    }
                    else{
                        sumOfProfit=sumOfProfit+(localmaxima-localMinima);
                        i=j;
                        break;
                    }
                    System.out.println("");

                }
                localmaxima=Integer.MIN_VALUE;

            }else {

                break;
            }

        }

        return sumOfProfit;
    }

    public static int maxProfit2(int[] prices){
        int profit = 0;
        for(int i=1; i < prices.length; i++){
            if((prices[i] - prices[i-1]) > 0){
                profit+=(prices[i] - prices[i-1]);
            }
        }
        return profit > 0 ? profit : 0 ;
    }
}
