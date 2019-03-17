package com.gmail.chernii.oleksii.collections.map;

import java.util.concurrent.ConcurrentMap;

/**
 * Created by Space on 17.03.2019.
 */
public class ReadMapThread implements Runnable {
    private ConcurrentMap<Integer, String> map;
    private Thread thread;

    public ReadMapThread(String name, ConcurrentMap<Integer, String> map) {
        thread = new Thread(this, name);
        this.map = map;
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        for (ConcurrentMap.Entry<Integer, String> entry : map.entrySet()) {
            sb.append(entry.getKey() + ":" + entry.getValue() + "\n");
        }
        System.out.println(sb.toString());
    }
}
