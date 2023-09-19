package com.ivansoft.java.exercises.concurrencyparalelism.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HandlingError {
    public static void example() {
        CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
            if (Math.random() < 0.5) {
                throw new RuntimeException("Error on task");
            }
            return "Successful task";
        });

        CompletableFuture<String> handledResult = result
                .exceptionally(ex -> {
                    System.err.println("caught exception: " + ex.getMessage());
                    return "Error handled on exceptionally"; // Return a default value
                })
                .handle((success, ex) -> {
                    if (ex != null) {
                        System.err.println("caught exception on handle: " + ex.getMessage());
                        return "Error handled on handle"; // Return a default value
                    }
                    return success;
                });

        try {
            String finalResult = handledResult.get();
            System.out.println("Result: " + finalResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
