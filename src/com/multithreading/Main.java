package com.multithreading;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Almas_Doskozhin
 * on 10/8/2018.
 */
public class Main {
    private static int BOUND = 20;
    private static int N_PRODUCERS = 5;
    private static int M_CONSUMERS = 3;

    public static void main(String[] args) {
        generateNumbers();
    }

    public static void generateNumbers() {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(BOUND);
        Random rand = new Random();


        for (int i = 0; i < N_PRODUCERS; i++) {
            new Thread(new NumberGenerator(queue, rand)).start();
        }

        for (int i = 0; i < M_CONSUMERS; i++) {
            new Thread(new NumberWriter(queue)).start();
        }
    }
}

