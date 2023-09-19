package com.ivansoft.java.exercises.concurrencyparalelism;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrencySimple {
    public static void main(String[] args) {
        simpleTasks();
        sumThreading();
    }

    public static void simpleTasks() {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1(500ms): " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2(1000ms): " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    public static void sumThreading() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        AtomicInteger sum = new AtomicInteger();

        Thread thread1 = new Thread(() -> {
            for (int number : numbers) {
                sum.addAndGet(number);
            }
            System.out.println("The sum of the first half of the numbers is " + sum);
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 4; i < numbers.length; i++) {
                sum.addAndGet(numbers[i]);
            }
            System.out.println("The sum of the second half of the numbers is " + sum);
        });

        thread1.start();
        thread2.start();
    }
}
