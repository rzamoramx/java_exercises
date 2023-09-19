package com.ivansoft.java.exercises.algos;

public class LinealSearch {
    public int search(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            if (current == target) {
                return i;
            }
        }
        return -1;
    }
}
