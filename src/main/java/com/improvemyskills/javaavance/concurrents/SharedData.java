package com.improvemyskills.javaavance.concurrents;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedData {
    private int value = 0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    // Lecture (verrou partagé)
    public int read() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " lit: " + value);
            return value;
        } finally {
            lock.readLock().unlock();
        }
    }

    // Écriture (verrou exclusif)
    public void write(int newValue) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " écrit: " + newValue);
            value = newValue;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        SharedData data = new SharedData();

        // Threads lecteurs
        Runnable reader = () -> {
            for (int i = 0; i < 3; i++) data.read();
        };

        // Threads écrivains
        Runnable writer = () -> {
            for (int i = 0; i < 3; i++) data.write((int)(Math.random() * 100));
        };

        // Lancement
        for (int i = 0; i < 3; i++) new Thread(reader, "Lecteur-" + i).start();
        for (int i = 0; i < 2; i++) new Thread(writer, "Écrivain-" + i).start();
    }
}
