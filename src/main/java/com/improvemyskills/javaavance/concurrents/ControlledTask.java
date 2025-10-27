package com.improvemyskills.javaavance.concurrents;

class ControlledTask implements Runnable {
    private volatile boolean running = true;
    public void run() {
        int i = 0;
        while (running) {
            System.out.println("En cours..."+i++);
        }
    }
    public void stop() {
        running = false;
    }

    public static void main(String[] args) throws InterruptedException {
        ControlledTask controlledTask = new ControlledTask();
        Thread thread = new Thread(controlledTask);
        thread.start();
        Thread.sleep(15);
        controlledTask.stop();
    }
}

