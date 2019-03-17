package com.gmail.chernii.oleksii.synchronizers.phaser;

import java.util.concurrent.Phaser;

/**
 * Created by Space on 17.03.2019.
 */
public class PhaseThread implements Runnable {
    private Phaser phaser;
    private String name;

    PhaseThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " performs phase " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
            Thread.sleep(200);
            System.out.println(name + " performs phase " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
            Thread.sleep(200);
            System.out.println(name + " performs phase " + phaser.getPhase());
            phaser.arriveAndDeregister();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}