package com.improvemyskills.javaavance.concurrents;

class Ressources {
    public void action(Ressources autre) {
        Ressources first = this.hashCode() < autre.hashCode() ? this : autre;
        Ressources second = this.hashCode() < autre.hashCode() ? autre : this;

        synchronized (first) {
            System.out.println(Thread.currentThread().getName() + " verrouille " + first);
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (second) {
                System.out.println(Thread.currentThread().getName() + " verrouille " + second);
            }
        }
    }
}
