package com.gmail.chernii.oleksii.queues;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Space on 17.03.2019.
 */
public class ReaderQueue implements Runnable {
    private BlockingQueue<Integer> queue;
    private Thread thread;

    public ReaderQueue(String name, BlockingQueue<Integer> queue) {
        this.queue = queue;
        thread = new Thread(this, name);
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
        sb.append(thread.getName() + "\n");
        queue.forEach(e -> {
            sb.append(e);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });
        System.out.println(sb.toString());
        System.out.println(thread.getName() + "done");
    }
}
