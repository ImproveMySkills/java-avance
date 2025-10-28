package com.improvemyskills.javaavance.forkjoin;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

// Classe qui calcule la somme d'un tableau en parallèle
class SumTask extends RecursiveTask<Long> {
    private final int[] array;
    private final int start, end;
    private static final int THRESHOLD = 10; // Taille minimale pour diviser

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) sum += array[i];
            return sum;
        } else {
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(array, start, mid);
            SumTask rightTask = new SumTask(array, mid, end);
            leftTask.fork(); // Exécute en parallèle
            return rightTask.compute() + leftTask.join(); // Combine les résultats
        }
    }
}

public class ForkJoinExample {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) numbers[i] = i + 1;

        ForkJoinPool pool = new ForkJoinPool();
        long result = pool.invoke(new SumTask(numbers, 0, numbers.length));
        System.out.println("Somme = " + result);
    }
}