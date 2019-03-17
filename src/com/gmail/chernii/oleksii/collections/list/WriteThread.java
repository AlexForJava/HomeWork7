package com.gmail.chernii.oleksii.collections.list;

import java.util.List;

/**
 * Created by Space on 17.03.2019.
 */
public class WriteThread extends Thread {
    private List<Integer> list;

    public WriteThread(String name, List<Integer> list) {
        super.setName(name);
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 5; i < 10; i++) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(i);
        }

        System.out.println(super.getName() + " done");
    }
}
