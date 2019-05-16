package com.gmail.chernii.oleksii.synchronizers.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by Space on 17.03.2019.
 */
public class SemaphoreExample {
    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(3, Boolean.TRUE);
        for (int i = 0; i < 5; i++) {
            new SemaphoreExampleThread("Thread-" + i, semaphore);
        }
    }
}
