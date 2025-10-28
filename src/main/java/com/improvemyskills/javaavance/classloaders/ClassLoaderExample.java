package com.improvemyskills.javaavance.classloaders;

public class ClassLoaderExample {
    public static void main(String[] args) throws Exception {
        // Obtenir le ClassLoader du programme
        ClassLoader classLoader = ClassLoaderExample.class.getClassLoader();
        System.out.println("ClassLoader actuel : " + classLoader);

        // Charger une classe dynamiquement
        Class<?> clazz = classLoader.loadClass("java.util.ArrayList");
        System.out.println("Classe chargée : " + clazz.getName());
    }
}