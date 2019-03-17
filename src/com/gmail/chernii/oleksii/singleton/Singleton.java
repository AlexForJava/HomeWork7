package com.gmail.chernii.oleksii.singleton;

/**
 * Created by Space on 17.03.2019.
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
