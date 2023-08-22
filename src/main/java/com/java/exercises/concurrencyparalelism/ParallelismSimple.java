package com.java.exercises.concurrencyparalelism;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelismSimple {
    public static void main(String[] args) {
        simpleTasks();
        sumParallelism();
    }

    public static void simpleTasks() {
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
            executorService.submit(() -> {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Task 1 (500ms): " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            executorService.submit(() -> {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Task 2 (1000ms): " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            executorService.shutdown();
        }
    }

    public static  void sumParallelism() {
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {

            int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

            executorService.submit(() -> {
                int sum = 0;
                for (int number : numbers) {
                    sum += number;
                }
                System.out.println("The sum of the first half of the numbers is " + sum);
            });

            executorService.submit(() -> {
                int sum = 0;
                for (int i = 5; i < numbers.length; i++) {
                    sum += numbers[i];
                }
                System.out.println("The sum of the second half of the numbers is " + sum);
            });

            executorService.shutdown();
        }
    }
}
