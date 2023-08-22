package com.java.exercises.concurrencyparalelism;

import java.util.concurrent.CompletableFuture;

public class Async {
    static void simpleAsync() {
        // Run a task asynchronously that returns a result
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // Simulates an operation that takes time
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        });

        // Wait for the result of the asynchronous task
        future.thenAccept(result -> {
            System.out.println("Result: " + result);
        });

        // Ensure that the application does not end before the CompletableFuture is completed
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
