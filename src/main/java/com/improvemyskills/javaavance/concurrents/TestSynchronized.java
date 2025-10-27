package com.improvemyskills.javaavance.concurrents;

class CompteBancaire {
    private int solde;

    public CompteBancaire(int soldeInitial) {
        this.solde = soldeInitial;
    }

    // Méthode synchronisée pour dépôt
    public synchronized void deposer(int montant) {
        solde += montant;
        System.out.println(Thread.currentThread().getName() + " a déposé " + montant + " | Solde: " + solde);
    }

    // Méthode synchronisée pour retrait
    public synchronized void retirer(int montant) {
        if (solde >= montant) {
            solde -= montant;
            System.out.println(Thread.currentThread().getName() + " a retiré " + montant + " | Solde: " + solde);
        } else {
            System.out.println(Thread.currentThread().getName() + " retrait refusé (solde insuffisant)");
        }
    }

    public int getSolde() {
        return solde;
    }
}

public class TestSynchronized {
    public static void main(String[] args) {
        CompteBancaire compte = new CompteBancaire(100);

        Runnable tacheDepot = () -> {
            for (int i = 0; i < 5; i++) {
                compte.deposer(20);
            }
        };

        Runnable tacheRetrait = () -> {
            for (int i = 0; i < 5; i++) {
                compte.retirer(15);
            }
        };

        Thread t1 = new Thread(tacheDepot, "Thread-Dépôt");
        Thread t2 = new Thread(tacheRetrait, "Thread-Retrait");

        t1.start();
        t2.start();
    }
}