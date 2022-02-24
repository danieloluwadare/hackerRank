package com.company.ExecutiveFramework;

import java.util.concurrent.CompletableFuture;

public class CompleteAbleFutureDemo2 {
    public static void main(String[] args) {
//        getEmailAsync()
//                .thenComposeAsync(CompleteAbleFutureDemo2::getPlayListAsync)
//                .thenAcceptAsync(System.out::println);

        combiningCompleteAbleFuture();
    }
    public static CompletableFuture<String> getEmailAsync(){
        return CompletableFuture.supplyAsync(() -> {
            return "email";
        });
    }

    public static CompletableFuture<String> getPlayListAsync(String email){
        return CompletableFuture.supplyAsync(() -> {
            return "playList";
        });
    }

    public static void combiningCompleteAbleFuture(){
        CompletableFuture<Integer> getUsdTask = CompletableFuture.supplyAsync(()-> 30);
        CompletableFuture<Integer> getRateTask = CompletableFuture.supplyAsync(()-> 500);

        getUsdTask.thenCombine(getRateTask,(usd, rate)-> usd * rate)
                .thenAccept(result -> System.out.println(result));
    }

    public static void combiningManyCompleteAbleFutureTask(){
        CompletableFuture<Integer> firstTask = CompletableFuture.supplyAsync(()-> 30);
        CompletableFuture<Integer> secondTask = CompletableFuture.supplyAsync(()-> 500);
        CompletableFuture<Integer> thirdTask = CompletableFuture.supplyAsync(()-> 500);
        
        CompletableFuture<Void> mergedMappedObjectFutures = CompletableFuture.allOf(firstTask,secondTask,thirdTask);

    }
}
