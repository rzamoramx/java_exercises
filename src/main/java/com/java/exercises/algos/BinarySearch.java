package com.java.exercises.algos;

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
}
