package com.ivansoft.java.exercises.algos.sorting;

import java.util.Arrays;

public class RadixSort {
    // Method to get digits in the specified position.
    private static int getDigit(int number, int position) {
        // Uses the division and modulo operations to get the digits in the specified position, starting from the right.
        System.out.println("number: " + number + ", position: " + position + ", digit: " + (number / (int) Math.pow(10, position)) % 10);
        return (number / (int) Math.pow(10, position)) % 10;
    }

    // Method to get the maximum number of digits in the list.
    private static int getMaxDigits(int[] arr) {
        // Find the maximum number in the list to get its digit count.
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        // Count the number of digits of the maximum number.
        int digitCount = 0;
        while (max != 0) {
            max /= 10;
            digitCount++;
        }
        return digitCount;
    }

    // Counting sort method to get the sorted list based on the specific digit.
    private static void countingSortByDigit(int[] arr, int digit) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Count the frequency appearance of each digit iny the array.
        for (int i = 0; i < n; i++) {
            count[getDigit(arr[i], digit)]++;
        }
        System.out.println("count: " + Arrays.toString(count));

        // Modify the count array to store the final positions of each digit in the output array.
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        System.out.println("count: " + Arrays.toString(count));

        // Build output array putting elements into their position according to the current digit.
        for (int i = n - 1; i >= 0; i--) {
            output[count[getDigit(arr[i], digit)] - 1] = arr[i];
            count[getDigit(arr[i], digit)]--;
        }
        System.out.println("output: " + Arrays.toString(output));

        // Copy the elements of the output array to the original array.
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Method to order list
    public static void radixSort(int[] arr) {
        int maxDigits = getMaxDigits(arr);
        for (int digit = 0; digit < maxDigits; digit++) {
            System.out.println("Ordering by digit " + digit);
            countingSortByDigit(arr, digit);
            System.out.println("Current order of array: " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Before sort: " + Arrays.toString(arr));

        radixSort(arr);

        System.out.println("After sort: " + Arrays.toString(arr));
    }
}
