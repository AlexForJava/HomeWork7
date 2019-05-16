package com.gmail.chernii.oleksii.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Space on 17.03.2019.
 */
public class AtomicExample {
    public static void main(String[] args) throws InterruptedException {
        atomicIntegerMethod();
        atomicLongMethod();
        atomicArrayIntegerMethod();
    }

    public static void atomicIntegerMethod() throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 100; i++) {
            new Thread(atomicInteger::incrementAndGet).start();
            Thread.sleep(1);
        }
        Thread.sleep(100);
        System.out.println("AtomicInteger = " + atomicInteger.get());
        System.out.println();
    }

    public static void atomicLongMethod() throws InterruptedException {
        AtomicLong atomicLong = new AtomicLong(0);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> atomicLong.addAndGet(1)).start();
            Thread.sleep(1);
        }
        Thread.sleep(100);
        System.out.println("AtomicLong = " + atomicLong.get());
        System.out.println();
    }

    public static void atomicArrayIntegerMethod() throws InterruptedException {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);
        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            final int temp = i;
            new Thread(() -> atomicIntegerArray.set(temp, temp)).start();
            Thread.sleep(1);
        }
        Thread.sleep(100);
        System.out.println(atomicIntegerArray.toString());
    }
}
