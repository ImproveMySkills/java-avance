package com.improvemyskills.javaavance.dynamicinstanciation;

import java.lang.reflect.Method;

public class DynamicInstantiationExample {
    public static void main(String[] args) throws Exception {
        // 1. Charger la classe dynamiquement
        Class<?> clazz = Class.forName("java.lang.String");

        // 2. Créer une instance avec un constructeur
        Object obj = clazz.getConstructor(String.class).newInstance("Hello Reflection");

        // 3. Récupérer la méthode toUpperCase()
        Method method = clazz.getMethod("toUpperCase");

        // 4. Appeler la méthode dynamiquement
        Object result = method.invoke(obj);
        System.out.println("Résultat : " + result); // Affiche HELLO REFLECTION
    }
}