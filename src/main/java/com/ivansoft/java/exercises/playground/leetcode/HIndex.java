package com.ivansoft.java.exercises.playground.leetcode;

import java.util.Arrays;

public class HIndex {
    /**
     * This class is used to find the h-index of a researcher, an exercise from LeetCode.
     * This could be solved using this approach:
     * first order the citations in descending order and second use binary search to find the h-index.
     */
    public static int getSolution(int[] citations) {
        // sort the citations in descending order
        Arrays.sort(citations);

        int n = citations.length;
        int left = 0;
        int right = n - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (citations[mid] == n - mid) {
                return n - mid;
            } else if (citations[mid] < n - mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return n - left;
    }
}
