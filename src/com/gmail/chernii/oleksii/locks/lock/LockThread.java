package com.gmail.chernii.oleksii.locks.lock;

import com.gmail.chernii.oleksii.locks.Base;

import java.util.concurrent.locks.Lock;

/**
 * Created by Space on 17.03.2019.
 */
public class LockThread implements Runnable {
    private Base base;
    private Lock lock;

    public LockThread(Base base, Lock lock) {
        this.base = base;
        this.lock = lock;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println(base.getCount());
            base.setCount(base.getCount() + 1);
            Thread.sleep(100);
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
