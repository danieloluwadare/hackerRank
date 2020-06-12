package com.company.ExecutiveFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void show(){
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for(int i = 0; i<10; i++){
            executor.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}
