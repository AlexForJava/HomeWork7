package com.gmail.chernii.oleksii.collections.list;

import java.util.List;

/**
 * Created by Space on 17.03.2019.
 */
public class ReadThread extends Thread {
    private List<Integer> list;

    public ReadThread(String name, List<Integer> list) {
        super.setName(name);
        this.list = list;
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(super.getName() + ":\n");
        list.forEach(sb::append);
        sb.append("\n");
        System.out.println(sb.toString());
    }
}
