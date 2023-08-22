package com.java.exercises.reactiveprogramming;

import reactor.core.publisher.Flux;

public class ReactorExample {
    public static void main(String[] args) {
        // Create a flux of integers
        Flux<Integer> flux = Flux.range(1, 5);

        // Subscribe to the flux and print the emitted values
        flux.subscribe(
                value -> System.out.println("Emitted value: " + value),
                error -> System.err.println("Error: " + error),
                () -> System.out.println("Completed successfully")
        );
    }
}
