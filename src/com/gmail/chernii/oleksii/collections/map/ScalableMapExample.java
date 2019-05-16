package com.gmail.chernii.oleksii.collections.map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by Space on 17.03.2019.
 */
public class ScalableMapExample {
    public static void main(String[] args) {
        ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(0, "main");
        map.put(1, "main");
        map.put(2, "main");
        map.put(3, "main");
        map.put(4, "main");
        new WriteMapThread("Writer", map).start();
        new ReadMapThread("Reader", map).start();
    }
}
