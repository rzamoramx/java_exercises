package com.java.exercises.algos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    BinarySearch binarySearch;

    @BeforeEach
    void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    void search() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int target = 2;
        int expected = 1;

        int result = binarySearch.search(array, target);
        assertEquals(expected, result);
    }
}