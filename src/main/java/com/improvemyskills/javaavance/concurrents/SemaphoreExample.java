package com.improvemyskills.javaavance.concurrents;

import java.util.concurrent.*;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2); // max 2 threads
        Runnable task = () -> {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " accède à la ressource");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        };

        for (int i = 0; i < 5; i++) new Thread(task).start();
    }
}