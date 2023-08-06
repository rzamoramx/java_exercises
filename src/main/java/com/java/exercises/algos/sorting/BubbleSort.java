package com.java.exercises.algos.sorting;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] bubbleTestArr = {64, 34, 25, 12, 22, 11, 90};
        BubbleSort.bubbleSort(bubbleTestArr);
        System.out.println("Bubble Sort:");
        for (int num : bubbleTestArr) {
            System.out.print(num + " ");
        }
    }
}
