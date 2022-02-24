package com.company.ExecutiveFramework.ThreadPlayGround.LockExamples;

public class PrintNumberTask implements Runnable{
    private IntegerProcessor integerProcessor;
    private int maximumNumber;

    public PrintNumberTask(IntegerProcessor integerProcessor, int maximumNumber) {
        this.integerProcessor = integerProcessor;
        this.maximumNumber = maximumNumber;
    }

    @Override
    public void run() {
        while (integerProcessor.getValue() < maximumNumber){
            integerProcessor.increment();
        }
    }
}
