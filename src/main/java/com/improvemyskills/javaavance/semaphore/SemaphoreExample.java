package com.improvemyskills.javaavance.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private final Semaphore semaphore = new Semaphore(2); // Autorise 2 threads simultanés

    public void accessResource() {
        try {
            semaphore.acquire(); // Demande une permission
            System.out.println(Thread.currentThread().getName() + " accède à la ressource");
            Thread.sleep(1000); // Simule un traitement
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " libère la ressource");
            semaphore.release(); // Libère la permission
        }
    }

    public static void main(String[] args) {
        SemaphoreExample example = new SemaphoreExample();

        for (int i = 0; i < 5; i++) {
            new Thread(example::accessResource, "Thread-" + i).start();
        }
    }
}