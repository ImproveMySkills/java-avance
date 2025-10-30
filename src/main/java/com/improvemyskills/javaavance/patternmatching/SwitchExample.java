package com.improvemyskills.javaavance.patternmatching;

public class SwitchExample {
    public static void main(String[] args) {


        String day = "Samedi";


        switch (day.toLowerCase()) {
            case "lundi", "mardi", "mercredi", "jeudi", "vendredi" -> System.out.println("Jour ouvrable");
            case "samedi", "dimanche" -> System.out.println("Weekend");
            default -> System.out.println("Invalide");
        }

    }

    public static void jourOuvrables(String day){
        switch (day.toLowerCase()) {
            case "lundi", "mardi", "mercredi", "jeudi", "vendredi" -> System.out.println("Jour ouvrable");
            case "samedi", "dimanche" -> System.out.println("Weekend");
            default -> System.out.println("Invalide");
        }
    }
}