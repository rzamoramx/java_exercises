package com.ivansoft.java.exercises.algos.sorting;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap the smallest element found with the first unsorted element
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    public static void main(String[] args) {
        int[] selectionTestArr = {64, 25, 12, 22, 11};
        SelectionSort.selectionSort(selectionTestArr);
        System.out.println("Selection Sort:");
        for (int num : selectionTestArr) {
            System.out.print(num + " ");
        }
    }
}
