package com.company.ExecutiveFramework.ThreadPlayGround.LockExamples;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntegerProcessor {
    private AtomicInteger value;
    private Lock lock;

    public IntegerProcessor() {
        this.value = new AtomicInteger(0);
        this.lock = new ReentrantLock();;
    }

    public void increment(){
        value.incrementAndGet();
        System.out.println(getValue());
    }

    public int getValue() {
        return value.get();
    }

}
