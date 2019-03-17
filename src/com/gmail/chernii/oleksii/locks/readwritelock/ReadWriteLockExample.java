package com.gmail.chernii.oleksii.locks.readwritelock;

import com.gmail.chernii.oleksii.locks.Base;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Space on 17.03.2019.
 */
public class ReadWriteLockExample {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Base base = new Base();
        for (int i = 0; i < 10; i++) {
            new ReadWriteLockThread(readWriteLock, base);
        }
    }
}
