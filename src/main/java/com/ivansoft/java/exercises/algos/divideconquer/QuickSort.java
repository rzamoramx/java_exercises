package com.ivansoft.java.exercises.algos.divideconquer;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIdx = partition(arr, low, high);
            quickSort(arr, low, pivotIdx - 1);
            quickSort(arr, pivotIdx + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap elements to place the smaller ones to the left of the pivot
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Put the pivot in its correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] quickTestArr = {10, 7, 8, 9, 1, 5};
        QuickSort.quickSort(quickTestArr, 0, quickTestArr.length - 1);
        System.out.println("QuickSort:");
        for (int num : quickTestArr) {
            System.out.print(num + " ");
        }
    }
}
