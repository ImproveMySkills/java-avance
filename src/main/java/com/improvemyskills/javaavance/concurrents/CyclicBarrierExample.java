package com.improvemyskills.javaavance.concurrents;

import java.util.concurrent.*;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("Tous les threads ont atteint la barrière"));

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " en attente...");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 3; i++) new Thread(task).start();
    }
}
