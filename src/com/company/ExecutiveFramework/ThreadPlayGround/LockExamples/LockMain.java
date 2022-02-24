package com.company.ExecutiveFramework.ThreadPlayGround.LockExamples;

public class LockMain {
    public static void main(String[] args) throws InterruptedException {
//        IntegerProcessor integerProcessor = new IntegerProcessor();
//        Thread thread1 = new Thread(new PrintNumberTask(integerProcessor,10));
//        Thread thread2 = new Thread(new PrintNumberTask(integerProcessor,10));
//        thread1.start();
//        thread2.start();
//        int a = 0;
//        int b = 0;
//        System.out.println(++a);
//        System.out.println(b++);

//        TaskEvenOdd taskEvenOdd = new TaskEvenOdd(10);
//        Thread thread1 = new Thread(taskEvenOdd);
//        Thread thread2 = new Thread(taskEvenOdd);
//
//        thread1.start();
//        thread2.start();

        TaskEvenOdd t = new TaskEvenOdd(10);
        Thread t1 = new Thread(t, "odd printer");
        Thread t2 = new Thread(t, "even printer");
        t1.start();
        t2.start();

    }
}
