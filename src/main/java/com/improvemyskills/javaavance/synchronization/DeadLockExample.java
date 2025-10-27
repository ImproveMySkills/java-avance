package com.improvemyskills.javaavance.synchronization;

public class DeadLockExample {

    public static void main(String[] args) {

        Ressources r1 = new Ressources();
        Ressources r2 = new Ressources();

        Thread t1 = new Thread(() -> r1.action(r2), "T1");
        Thread t2 = new Thread(() -> r2.action(r1), "T2");

        t1.start();
        t2.start();

    }
}

class Ressources {
    public synchronized void action(Ressources autre) {
        System.out.println(Thread.currentThread().getName() + " verrouille " + this);
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        autre.action2();
    }
    public synchronized void action2() {
        System.out.println(Thread.currentThread().getName() + " verrouille action2");
    }
}
