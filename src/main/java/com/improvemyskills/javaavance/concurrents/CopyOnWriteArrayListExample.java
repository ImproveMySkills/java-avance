package com.improvemyskills.javaavance.concurrents;

import java.util.concurrent.*;
import java.util.*;

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Ajout d'éléments
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // Lecture concurrente
        for (String lang : list) {
            System.out.println(lang);
        }

        // Modification pendant l'itération (autorisé)
        list.add("Go");
        System.out.println("Après ajout: " + list);
    }
}