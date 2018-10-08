package com.multithreading;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class NumberGenerator implements Runnable {
    private final BlockingQueue<Integer> fileQueue;
    private Random rand;

    public NumberGenerator(BlockingQueue<Integer> queue, Random rand) {
        fileQueue = queue;
        this.rand = rand;
    }

    public void run() {
        try {
            while (true) {
                fileQueue.put(rand.nextInt(50) + 1);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}




