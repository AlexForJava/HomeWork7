package com.gmail.chernii.oleksii.locks.lock;

import com.gmail.chernii.oleksii.locks.Base;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Space on 17.03.2019.
 */
public class LockExample {
    public static void main(String[] args) {
        Base base = new Base();
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++)
            new LockThread(base, lock);
    }
}
