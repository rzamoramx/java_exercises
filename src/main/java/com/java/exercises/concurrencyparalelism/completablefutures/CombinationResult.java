package com.java.exercises.concurrencyparalelism.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CombinationResult {
    public static void allOfExample() {
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> "Result of task 1");
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> "Result of task 2");
        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> "Result of task 3");

        CompletableFuture<Void> allOfResult = CompletableFuture.allOf(task1, task2, task3);

        try {
            allOfResult.get(); // Wait for all tasks to complete
            System.out.println("All tasks have been completed");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void anyOfExample() {
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> "Result of task 1");
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> "Result of task 2");
        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> "Result of task 3");

        CompletableFuture<Object> anyOfResult = CompletableFuture.anyOf(task1, task2, task3);

        try {
            Object result = anyOfResult.get();
            System.out.println("First completed task: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
