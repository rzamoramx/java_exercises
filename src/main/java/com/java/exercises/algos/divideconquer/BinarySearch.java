package com.java.exercises.algos.divideconquer;

public class BinarySearch {
    public int search(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int middle = 0;

        while(left <= right) {
            middle = (left + right) / 2;

            System.out.println(" ****** ");
            System.out.println("left: " + left + ", right: " + right + ", middle: " + middle);

            if (array[middle] == target) {
                System.out.println("found target: " + target);
                return middle;
            } else if (target > array[middle]) {
                left = middle + 1;
                System.out.println("target=" + target + " is greater than array[middle]=" + array[middle] + ", so left=" + left);
            } else {
                right = middle - 1;
                System.out.println("target=" + target + " is less than array[middle]=" + array[middle] + ", so right=" + right);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int target = 25;

        System.out.println("array: " + java.util.Arrays.toString(array));
        System.out.println("target: " + target);
        System.out.println("index of target: " + binarySearch.search(array, target));
    }
}
