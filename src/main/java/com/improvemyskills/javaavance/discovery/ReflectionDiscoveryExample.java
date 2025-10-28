package com.improvemyskills.javaavance.discovery;

import java.lang.reflect.Method;

public class ReflectionDiscoveryExample {
    public static void main(String[] args) throws Exception {
        // Obtenir la classe String
        Class<?> clazz = Class.forName("java.lang.String");

        // Afficher toutes les méthodes déclarées
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Méthodes de la classe String :");
        for (Method m : methods) {
            System.out.println("- " + m.getName());
        }
    }
}