package com.ivansoft.java.exercises.reactiveprogramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuturesExample {
    public static void main(String[] args) {
        CompletableFuture<Double> priceFuture = getPriceAsync("example-product");

        CompletableFuture<Double> discountedPriceFuture = priceFuture.thenApplyAsync(price -> applyDiscount(price, 0.1));

        CompletableFuture<Void> printFuture = discountedPriceFuture.thenAcceptAsync(discountedPrice ->
                System.out.println("Discounted Price: " + discountedPrice)
        );

        // wait for the future to complete
        try {
            printFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<Double> getPriceAsync(String product) {
        // Simulate getting price
        return CompletableFuture.supplyAsync(() -> {
            double price = 100.0;
            return price;
        });
    }

    public static double applyDiscount(double price, double discount) {
        return price * (1 - discount);
    }
}
