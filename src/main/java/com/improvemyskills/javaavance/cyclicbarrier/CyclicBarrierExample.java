package com.improvemyskills.javaavance.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        // Barrière pour 3 threads avec une action quand tous sont arrivés
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("Tous les threads ont atteint la barrière. Étape terminée !");
        });

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " commence son travail");
                    Thread.sleep((int)(Math.random() * 2000)); // Simule un travail
                    System.out.println(Thread.currentThread().getName() + " attend à la barrière");
                    barrier.await(); // Synchronisation
                    System.out.println(Thread.currentThread().getName() + " continue après la barrière");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "Thread-" + i).start();
        }
    }
}