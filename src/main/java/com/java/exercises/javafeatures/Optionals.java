package com.java.exercises.javafeatures;

import java.util.Optional;

public class Optionals {
    static void performOptionals() {
        // Creation of an empty Optional
        Optional<String> emptyOptional = Optional.empty();

        // Creation of an Optional from a non-null value
        String value = "Hi!";
        Optional<String> nonNullOptional = Optional.of(value);

        // Creation of an Optional from a nullable value
        String nullableValue = null;
        Optional<String> nullableOptional = Optional.ofNullable(nullableValue);

        // Get the value of an Optional
        if (nonNullOptional.isPresent()) {
            String retrievedValue = nonNullOptional.get();
            System.out.println("Value: " + retrievedValue);
        }

        // Get the value of an Optional or a default value
        String defaultValue = "Default value";
        String retrievedValueOrDefault = emptyOptional.orElse(defaultValue);
        System.out.println("Given value or default value: " + retrievedValueOrDefault);

        // Perform operations conditionally with Optionals
        Optional<String> transformedOptional = nonNullOptional.map(String::toUpperCase);
        transformedOptional.ifPresent(System.out::println);
    }

    static Optional<String> getOptionalValue(int value) {
        if (value % 2 == 0) {
            return Optional.empty();
        }

        return Optional.of("Hi!");
    }
}
