package com.multithreading;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Almas_Doskozhin
 * on 10/8/2018.
 */
public class NumberWriter implements Runnable {
    private final BlockingQueue<Integer> queue;

    public NumberWriter(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                indexFile(queue.take());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void indexFile(Integer integer) {
        System.out.printf("Writing number %s \n", integer);
        FileSingleton.getInstance().writeToFile(String.format("%s - number was handled!!\n", integer));
    }
}
