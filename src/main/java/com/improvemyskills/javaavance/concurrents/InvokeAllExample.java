package com.improvemyskills.javaavance.concurrents;

import java.util.concurrent.*;
import java.util.*;

public class InvokeAllExample {
    public static void main(String[] args) {
        // Création d'un pool de threads fixe
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Liste des tâches Callable (elles retournent un résultat)
        List<Callable<String>> tasks = Arrays.asList(
                () -> {
                    Thread.sleep(1000);
                    return "Résultat de la tâche 1";
                },
                () -> {
                    Thread.sleep(2000);
                    return "Résultat de la tâche 2";
                },
                () -> {
                    Thread.sleep(1500);
                    return "Résultat de la tâche 3";
                }
        );

        try {
            // invokeAll exécute toutes les tâches et attend qu'elles terminent
            List<Future<String>> results = executor.invokeAll(tasks);

            // Parcours des résultats
            for (Future<String> future : results) {
                System.out.println(future.get()); // get() bloque jusqu'à la fin de la tâche
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}