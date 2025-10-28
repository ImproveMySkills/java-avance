package com.improvemyskills.javaavance.concurrents;

import java.util.concurrent.*;
import java.util.*;

/**
 * Chaque add() crée une nouvelle copie → coûteux si beaucoup d’écritures.
 * Lecture très rapide et sûre.
 * Itération sans exception même si la liste change.
 */
public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Ajout d'éléments
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // Lecture concurrente (aucun risque de ConcurrentModificationException)
        for (String lang : list) {
            System.out.println(lang);
        }

        // Modification pendant l'itération (autorisé car copie interne)
        list.add("Go");
        System.out.println("Après ajout: " + list);
    }
}