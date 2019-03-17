package com.gmail.chernii.oleksii.queues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Space on 17.03.2019.
 */
public class BlockingQueuesExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(8);
        for (int i = 0; i < 3; i++) {
            queue.add(i);
        }
        new WriterQueue("Writer", queue).start();
        new ReaderQueue("Reader", queue).start();
    }
}
