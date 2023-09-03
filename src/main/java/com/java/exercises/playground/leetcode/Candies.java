package com.java.exercises.playground.leetcode;

import java.util.Arrays;

public class Candies {
    public static void main(String[] args) {
        var input = new int[]{1, 0, 2};
        var result = candy(input);
        System.out.println("**********Result: " + result); // should be 5

        input = new int[]{1, 2, 2};
        result = candy(input);
        System.out.println("**********Result: " + result); // should be 4

        input = new int[]{1, 2, 87, 87, 87, 2, 1};
        result = candy(input);
        System.out.println("**********Result: " + result); // should be 13

        input = new int[]{1, 3, 4, 5, 2};
        result = candy(input);
        System.out.println("**********Result: " + result); // should be 11
    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // Scan from left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Scan from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candies[i];
        }
        return sum;
    }
}
