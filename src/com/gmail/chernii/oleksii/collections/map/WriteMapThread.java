package com.gmail.chernii.oleksii.collections.map;

import java.util.concurrent.ConcurrentMap;

/**
 * Created by Space on 17.03.2019.
 */
public class WriteMapThread extends Thread {
    private ConcurrentMap<Integer, String> map;

    public WriteMapThread(String name, ConcurrentMap<Integer, String> map) {
        super.setName(name);
        this.map = map;
    }

    @Override
    public void run() {
        for (int i = 5; i < 10; i++) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(i, super.getName());
        }
        System.out.println("WriterMap done...");
    }
}
