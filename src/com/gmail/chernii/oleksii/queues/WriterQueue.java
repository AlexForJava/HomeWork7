package com.gmail.chernii.oleksii.queues;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Space on 17.03.2019.
 */
public class WriterQueue implements Runnable {
    private BlockingQueue<Integer> queue;
    private Thread thread;

    public WriterQueue(String name, BlockingQueue<Integer> queue) {
        this.queue = queue;
        thread = new Thread(this, name);
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 6; i < 10; i++) {
            queue.add(i);
        }
        System.out.println(thread.getName() + " done");
    }
}
