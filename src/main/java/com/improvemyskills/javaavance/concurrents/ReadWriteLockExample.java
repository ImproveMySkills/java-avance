package com.improvemyskills.javaavance.concurrents;

import java.util.concurrent.locks.*;

public class ReadWriteLockExample {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int value = 0;

    public void write(int val) {
        lock.writeLock().lock();
        try {
            value = val;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int read() {
        lock.readLock().lock();
        try {
            return value;
        } finally {
            lock.readLock().unlock();
        }
    }
}
