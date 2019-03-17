package com.gmail.chernii.oleksii.locks.readwritelock;

import com.gmail.chernii.oleksii.locks.Base;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by Space on 17.03.2019.
 */
public class ReadWriteLockThread implements Runnable {
    private ReadWriteLock lock;
    private Base base;

    public ReadWriteLockThread(ReadWriteLock lock, Base base) {
        this.lock = lock;
        this.base = base;
        new Thread(this).start();
    }

    @Override
    public void run() {
        lock.writeLock().lock();
        lock.readLock().lock();
        System.out.println(base.getCount());
        base.setCount(base.getCount() + 1);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.readLock().unlock();
        lock.writeLock().unlock();
    }
}
