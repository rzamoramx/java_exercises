package com.java.exercises.concurrencyparalelism.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CombinationChaining {
    public static void thenComposeExample() {
        CompletableFuture<String> firstTask = CompletableFuture.supplyAsync(() -> "Result of the first task")
                .thenCompose(result -> {
                    if (Math.random() < 0.5) {
                        return CompletableFuture.failedFuture(new RuntimeException("Error on second task"));
                    }
                    return CompletableFuture.completedFuture(result + ", followed by second task");
                })
                .exceptionally(ex -> "Caught exception: " + ex.getMessage());

        try {
            String finalResult = firstTask.get();
            System.out.println("Final result: " + finalResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void thenCombineExample() {
        CompletableFuture<Integer> firstTask = CompletableFuture.supplyAsync(() -> {
            // throw exception randomly
            System.out.println(Math.random());
            if (Math.random() < 0.5) {
                throw new RuntimeException("Error on task");
            }
            return 10;
        });

        CompletableFuture<String> secondTask = CompletableFuture.supplyAsync(() -> "Result of the second task");

        CompletableFuture<String> combinedTask = firstTask.thenCombine(secondTask, (result1, result2) -> {
            return "Combined tasks: " + result1 + " | " + result2;
        }).exceptionally(ex -> "caught exception: " + ex.getMessage());

        try {
            String finalResult = combinedTask.get();
            System.out.println("Final result: " + finalResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void thenApplyExample() {
        CompletableFuture<Void> result = CompletableFuture.supplyAsync(() -> downloadFile("https://example.com/file.txt"))
                .thenApplyAsync(data -> {
                    try {
                        return processData(data);
                    } catch (Exception e) {
                        throw new RuntimeException("Error on processing data", e);
                    }
                })
                .thenAcceptAsync(resultData -> saveToDatabase(resultData))
                .exceptionally(ex -> {
                    System.err.println("Exception occurred: " + ex.getMessage());
                    return null; // handle error and return a default value
                });

        try {
            result.get(); // wait for all tasks to complete
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static String downloadFile(String url) {
        // Simulate file downloading
        return "Data downloaded from " + url;
    }

    public static String processData(String data) throws Exception {
        // Simulate processing data, throw exception if data contains "error"
        if (data.contains("error")) {
            throw new Exception("Error in data");
        }
        return "Data processed: " + data.toUpperCase();
    }

    public static void saveToDatabase(String data) {
        // Simulate saving to database
        System.out.println("Saving to database: " + data);
    }
}
