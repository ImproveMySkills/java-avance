package com.improvemyskills.javaavance.concurrents;

import java.util.concurrent.*;

/**
 * put() et get() sont thread-safe.
 * compute() permet une mise à jour atomique.
 * forEach() peut être exécuté en parallèle.
 */
public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Ajout de valeurs
        map.put("A", 1);
        map.put("B", 2);

        // Lecture concurrente
        System.out.println("Valeur pour A: " + map.get("A"));

        // Mise à jour atomique avec compute (évite les conditions de course)
        map.compute("A", (key, val) -> val + 10);
        System.out.println("Nouvelle valeur pour A: " + map.get("A"));

        // Parcours concurrent avec forEach (niveau de parallélisme = 1)
        map.forEach(1, (k, v) -> System.out.println(k + " -> " + v));
    }
}