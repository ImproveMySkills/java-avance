package com.improvemyskills.javaavance.synchronization;

public class MoniteurExample {

    public static void main(String[] args) {


        Ressource ressource = new Ressource();

        Thread producteur = new Thread(() -> {
            try { ressource.produire("Message"); } catch (InterruptedException e) {}
        });

        Thread consommateur = new Thread(() -> {
            try { ressource.consommer(); } catch (InterruptedException e) {}
        });

        producteur.start();
        consommateur.start();

    }
}

class Ressource {
    private String data;
    private boolean disponible = false;

    public synchronized void produire(String valeur) throws InterruptedException {
        while (disponible) wait();
        data = valeur;
        disponible = true;
        System.out.println("Produit : " + valeur);
        notifyAll();
    }

    public synchronized String consommer() throws InterruptedException {
        while (!disponible) wait();
        disponible = false;
        System.out.println("Consommé : " + data);
        notifyAll();
        return data;
    }
}
