package com.gmail.chernii.oleksii.synchronizers.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Space on 17.03.2019.
 */
public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Done");
        });
        for (int i = 0; i < 6; i++) {
            new CyclicBarrierExampleThread("Thread-" + i, cyclicBarrier);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
