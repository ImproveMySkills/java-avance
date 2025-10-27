package com.improvemyskills.javaavance.synchronization;

public class ExampleWithoutSynchronized {

    public static void main(String[] args) throws InterruptedException {
        Compteur compteur = new Compteur();

        Thread t1 = new Thread(() -> { for (int i = 0; i < 10000; i++) compteur.increment(); });
        Thread t2 = new Thread(() -> { for (int i = 0; i < 10000; i++) compteur.increment(); });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Valeur finale : " + compteur.getValeur()); // < 2000 (erreur)
    }
}

class Compteur {
    private int valeur = 0;
    public void increment() {
        valeur++;
    }
    public int getValeur() {
        return valeur;
    }
}
