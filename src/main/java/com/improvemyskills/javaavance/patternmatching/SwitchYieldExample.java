package com.improvemyskills.javaavance.patternmatching;

public class SwitchYieldExample {
    public static int getDays(String month) {
        return switch (month.toLowerCase()) {
            case "janvier", "mars", "mai", "juillet", "août", "octobre", "décembre" -> 31;
            case "avril", "juin", "septembre", "novembre" -> 30;
            case "février" -> 28;
            default -> throw new IllegalArgumentException("Mois invalide");
        };
    }

    public static void main(String[] args) {
        System.out.println(getDays("Mars")); // Affiche 31
    }
}