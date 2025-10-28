package com.improvemyskills.javaavance.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedExclusiveLockExample {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int value = 0;

    // Méthode d'écriture (exclusif)
    public void write(int newValue) {
        lock.writeLock().lock(); // Acquiert le verrou d'écriture
        try {
            System.out.println(Thread.currentThread().getName() + " écrit " + newValue);
            value = newValue;
            Thread.sleep(500); // Simule un traitement
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock(); // Libère le verrou
        }
    }

    // Méthode de lecture (partagé)
    public int read() {
        lock.readLock().lock(); // Acquiert le verrou de lecture
        try {
            System.out.println(Thread.currentThread().getName() + " lit " + value);
            Thread.sleep(200); // Simule un traitement
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return -1;
        } finally {
            lock.readLock().unlock(); // Libère le verrou
        }
    }

    public static void main(String[] args) {
        SharedExclusiveLockExample example = new SharedExclusiveLockExample();

        // Threads lecteurs
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) example.read();
            }, "Lecteur-" + i).start();
        }

        // Threads écrivains
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 3; j++) example.write((int)(Math.random() * 100));
            }, "Écrivain-" + i).start();
        }
    }
}
