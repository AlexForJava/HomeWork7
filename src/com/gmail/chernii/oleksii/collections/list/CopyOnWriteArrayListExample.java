package com.gmail.chernii.oleksii.collections.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Space on 17.03.2019.
 */
public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        new WriteThread("Writer", list).start();
        new ReadThread("Reader", list).start();
    }
}
