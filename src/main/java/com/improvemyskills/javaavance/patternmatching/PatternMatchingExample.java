package com.improvemyskills.javaavance.patternmatching;

public class PatternMatchingExample {
    public static void printInfo(Object obj) {
        if (obj instanceof String s) {
            System.out.println("Longueur : " + s.length());
        } else if (obj instanceof Integer i) {
            System.out.println("Double : " + (i * 2));
        } else {
            System.out.println("Type inconnu");
        }
    }

    public static void main(String[] args) {
        printInfo("Hello");   // Longueur : 5
        printInfo(10);        // Double : 20
        printInfo(3.14);      // Type inconnu
    }
}