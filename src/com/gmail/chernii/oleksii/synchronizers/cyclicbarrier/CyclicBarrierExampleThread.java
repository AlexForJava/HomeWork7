package com.gmail.chernii.oleksii.synchronizers.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Space on 17.03.2019.
 */
public class CyclicBarrierExampleThread implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private Thread thread;

    public CyclicBarrierExampleThread(String name, CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            cyclicBarrier.await();
            System.out.println(thread.getName() + " in progress...");
            System.out.println(thread.getName() + " done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
