package com.java.exercises.javafeatures;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamTest {
    // implement all tests for each method in Streams class
    @Test
    void testFilterEvenNumbers() {
        var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        var expected = List.of(2, 4, 6, 8);

        var result = Streams.filterEvenNumbers(numbers);
        assert result.equals(expected);
    }

    @Test
    void testConcatLists() {
        var list1 = List.of("hello", "Ivan");
        var list2 = List.of(", how", "are", "you", "?");
        var expected = List.of("hello", "Ivan", ", how", "are", "you", "?");

        var result = Streams.concatLists(list1, list2);
        assert result.equals(expected);
    }
    @Test
    void testMappingUpperCase() {
        var names = List.of("Ivan", "Juan", "Pedro", "Ana");
        var expected = List.of("IVAN", "JUAN", "PEDRO", "ANA");

        var result = Streams.mappingUpperCase(names);
        assert result.equals(expected);
    }

    @Test
    void testSortAlphabetically() {
        var names = List.of("Ivan", "Juan", "Pedro", "Ana");
        var expected = List.of("Ana", "Ivan", "Juan", "Pedro");

        var result = Streams.sortAlphabetically(names);
        assert result.equals(expected);
    }

    @Test
    void testReductionSum() {
        var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        var expected = 36;

        var result = Streams.reductionSum(numbers);
        assert result == expected;
    }

    @Test
    void testIterToUpperCase() {
        var names = List.of("Ivan", "Juan", "Pedro", "Ana", "Maria");

        Streams.iterToReplaceChar(names);
    }

    @Test
    void testIntermediateOperations() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 11, 11, 12);
        StreamExample.intermediateOperations(numbers);
    }

    @Test
    void testTerminalOperations() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 8, 10, 10, 10, 11);
        StreamExample.terminalOperations(numbers);
    }

    public static class StreamExample {
        public static void intermediateOperations(List<Integer> numbers) {
            List<Integer> filteredNumbers = numbers.stream()
                    .filter(n -> n % 2 == 0) // Filter pair numbers
                    .collect(Collectors.toList());
            System.out.println("Filtered numbers: " + filteredNumbers);

            List<Integer> mappedNumbers = numbers.stream()
                    .map(n -> n * n) // Square each number
                    .collect(Collectors.toList());
            System.out.println("Mapped numbers: " + mappedNumbers);

            List<Integer> flattenedNumbers = numbers.stream()
                    .flatMap(n -> Arrays.asList(n, n + 1).stream()) //Generate a list with each number and its successor
                    .collect(Collectors.toList());
            System.out.println("Flattened numbers: " + flattenedNumbers);

            List<Integer> distinctNumbers = numbers.stream()
                    .distinct() // Delete repeated numbers
                    .collect(Collectors.toList());
            System.out.println("Deleted all repeated numbers: " + distinctNumbers);

            List<Integer> sortedNumbers = numbers.stream()
                    .sorted() // Order numbers in ascending order
                    .collect(Collectors.toList());
            System.out.println("Ordered numbers: " + sortedNumbers);

            List<Integer> limitedNumbers = numbers.stream()
                    .limit(5) // Limit to the first 5 numbers
                    .collect(Collectors.toList());
            System.out.println("Limted numbers: " + limitedNumbers);

            List<Integer> skippedNumbers = numbers.stream()
                    .skip(5) // Skip the first 5 numbers
                    .collect(Collectors.toList());
            System.out.println("Skipped numbers: " + skippedNumbers);
        }

        public static void terminalOperations(List<Integer> numbers) {
            numbers.stream()
                    .forEach(System.out::println); // Print each number

            int sum = numbers.stream()
                    .reduce(0, Integer::sum); // Sum all numbers
            System.out.println("Total: " + sum);

            long count = numbers.stream()
                    .count(); // Count the total numbers
            System.out.println("Count numbers: " + count);

            boolean anyMatch = numbers.stream()
                    .anyMatch(n -> n > 5); // Verify if any number is greater than 5
            System.out.println("Is anyone greater than 5? " + anyMatch);

            boolean allMatch = numbers.stream()
                    .allMatch(n -> n > 0); // Verify if all numbers are greater than 0
            System.out.println("Are all numbers greater than 0? " + allMatch);

            boolean noneMatch = numbers.stream()
                    .noneMatch(n -> n < 0); // Verify if none number is less than 0
            System.out.println("Is none less than 0? " + noneMatch);

            Integer firstNumber = numbers.stream()
                    .findFirst() // Get the first number
                    .orElse(null);
            System.out.println("First number: " + firstNumber);

            Integer anyNumber = numbers.stream()
                    .findAny() // Get any number
                    .orElse(null);
            System.out.println("Any number: " + anyNumber);
        }
    }
}
