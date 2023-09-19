
package com.ivansoft.java.exercises.algos.divideconquer;
import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        // Step 2: Base case - If the array length is 1 or less, it is already sorted
        if (arr.length <= 1) {
            return;
        }

        // Step 3: Divide the array into two halves
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, mid, right, 0, right.length);

        // Visualize the left and right arrays
        System.out.println("left: " + Arrays.toString(left));
        System.out.println("right: " + Arrays.toString(right));

        // Step 5: Recursively sort the left and right halves
        mergeSort(left);
        mergeSort(right);

        // Step 6: Merge the sorted left and right halves
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Step 7: Merge the left and right arrays into the original array in sorted order
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Step 8: Copy any remaining elements from the left and right arrays
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }

        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82};
        //int[] arr = {38, 27, 43, 3, 9, 82, 10, 38, 27, 43, 3, 9, 82, 10, 38, 27, 43, 3, 9, 82, 10, 38, 27, 43, 3, 9, 82,
        //        10, 38, 27, 43, 3, 9, 82, 10, 38, 27, 43, 3, 9, 82, 10, 38, 27, 43, 3, 9, 82, 10, 38, 27, 43, 3, 9, 82,
        //        10, 38, 27, 43, 3, 9, 82, 10, 38, 27, 43, 3, 9, 82, 10, 38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
