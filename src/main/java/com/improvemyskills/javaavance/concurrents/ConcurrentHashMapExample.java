package com.improvemyskills.javaavance.concurrents;

import java.util.concurrent.*;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Ajout de valeurs
        map.put("A", 1);
        map.put("B", 2);

        // Lecture concurrente
        System.out.println("Valeur pour A: " + map.get("A"));

        // Mise à jour atomique
        map.compute("A", (key, val) -> val + 10);
        System.out.println("Nouvelle valeur pour A: " + map.get("A"));

        // Parcours concurrent
        map.forEach(1, (k, v) -> System.out.println(k + " -> " + v));
    }
}