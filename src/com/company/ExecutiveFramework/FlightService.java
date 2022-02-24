package com.company.ExecutiveFramework;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class FlightService {

    public  CompletableFuture<Quote> getQuote(String siteName){
        return CompletableFuture.supplyAsync(()->{
            Random random = new Random();
            int price = 100 + random.nextInt(10);
            try {
                Thread.sleep(price);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new Quote(siteName, price);
        });
    }
}
