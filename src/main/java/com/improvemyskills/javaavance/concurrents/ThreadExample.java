package com.improvemyskills.javaavance.concurrents;

public class ThreadExample extends Thread{

    public void run(){
        System.out.println("Exécution d'une tâche via Thread");
    }

    public static void main(String[] args) {
        ThreadExample threadExample = new ThreadExample();
        threadExample.start();
        threadExample.start();
/*        Thread t = new Thread(() -> System.out.println("Hello"));
        t.start(); // Lance un nouveau thread
        t.run();   // Exécute dans le thread principal (pas concurrent)*/
    }
}
