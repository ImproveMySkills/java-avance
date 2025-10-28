package com.improvemyskills.javaavance.completatblefuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
                    // Tâche asynchrone
                    return "Hello";
                }).thenApply(result -> result + " World") // Transformation
                .thenAccept(System.out::println); // Affichage
    }
}
