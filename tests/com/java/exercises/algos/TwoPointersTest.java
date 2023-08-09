package com.java.exercises.algos;

import org.junit.jupiter.api.Test;

public class TwoPointersTest {
    @Test
    void testCase1() {
        System.out.println("Rotate:");
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("nums: " + java.util.Arrays.toString(TwoPointers.rotate(arr1, 3)));

        System.out.println("Two Pointers:");
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 5, 6, 6, 7};

        System.out.println("nums: " + java.util.Arrays.toString(nums));
        System.out.println("length of nums after removing duplicates: " + TwoPointers.removeDuplicates(nums));
        System.out.println("nums: " + java.util.Arrays.toString(nums));
    }
}
