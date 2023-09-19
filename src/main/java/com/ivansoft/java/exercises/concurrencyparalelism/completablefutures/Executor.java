package com.ivansoft.java.exercises.concurrencyparalelism.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Executor {
    public static void example() {
        // Custom executor with 2 threads in the pool
        var executor = Executors.newFixedThreadPool(2);

        CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
                    // Simulate a long-running task
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (Math.random() < 0.5) {
                        throw new RuntimeException("Error on task");
                    }
                    return "Result of the first task";
                }, executor)
                .thenApplyAsync(data -> {
                    // Simulate a long-running task
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "Result of the second task from: " + data;
                }, executor)
                .exceptionally(ex -> {
                    System.err.println("Caught exception: " + ex.getMessage());
                    return "Failed task"; // return a default value
                });

        try {
            String finalResult = result.get();
            System.out.println("Final result: " + finalResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown(); // Shut down the executor
        }
    }
}
