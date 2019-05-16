package com.gmail.chernii.oleksii.synchronizers.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by Space on 17.03.2019.
 */
public class SemaphoreExampleThread implements Runnable {
    private Semaphore semaphore;
    private Thread thread;

    public SemaphoreExampleThread(String name, Semaphore semaphore) {
        this.semaphore = semaphore;
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(thread.getName() + " in progress...");
            Thread.sleep(1000);
            System.out.println(thread.getName() + " done...");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
