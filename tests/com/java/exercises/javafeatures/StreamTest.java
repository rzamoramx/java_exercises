package com.java.exercises.javafeatures;

import org.junit.jupiter.api.Test;
import java.util.List;

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
        var names = List.of("Ivan", "Juan", "Pedro", "Ana");

        Streams.iterToReplaceChar(names);
    }
}
