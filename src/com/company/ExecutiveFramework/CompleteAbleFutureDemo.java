package com.company.ExecutiveFramework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteAbleFutureDemo {
    public static void main(String[] args) {
//        testCompleteableFuture();

//        Object obj;
//        obj = new FlightService();
//        obj = new Mortgage();
//
//        if(obj instanceof  FlightService){
//            System.out.println(obj.getClass().getName());
//        }
//        if(obj instanceof  Mortgage){
//            System.out.println(obj.getClass().getName());
//        }
        FlightService flightService = new FlightService();

        flightService.getQuote("site 1")
                .thenAccept(quote -> System.out.println(quote.toString()));

        try {
            Thread.sleep(10_00);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("hello not waiting for thread");

    }



    private static void testCompleteableFuture() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
           return  1;
        });

        try {
            int result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
