package com.improvemyskills.javaavance.concurrents;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExample implements Runnable{
    @Override
    public void run() {
        System.out.println("Exécution d'une tâche Runnable");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableExample());
        thread.start();

        Thread thread1 = new Thread(
                () -> System.out.println("Exécution d'une tâche Runnable via Lambda")
        );

        thread1.start();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> System.out.println("Thread via ExecutorService"));
        executor.shutdown();
    }
}
