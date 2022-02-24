package com.company.ExecutiveFramework.ThreadPlayGround.LockExamples;

public class TaskEvenOdd implements Runnable{

    private int max;
    private boolean isOdd = true;
    private int number = 1;

    TaskEvenOdd(int max) {
        this.max = max;
    }

    synchronized void printEven() { // sync on runnable itself

        while (isOdd) { // if odd is to be printed, wait
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Even:" + this.number);  // LINE-1
        isOdd = true;
        this.number++;                             // LINE-2
        notifyAll();
    }

    synchronized void printOdd() { // sync on runnable itself
        while (!isOdd) { // if even is to be printed, wait
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Odd:" + this.number);    // LINE-3
        this.number++;                               // LINE-4
        isOdd = false;
        notifyAll();
    }

    @Override
    public void run() {

        while (number < max) {

            if (Thread.currentThread().getName().equals("even printer")) {
                printEven();
            } else {
                printOdd();
            }
        }
    }

}
