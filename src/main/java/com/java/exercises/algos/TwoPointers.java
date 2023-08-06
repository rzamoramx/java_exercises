package com.java.exercises.algos;

import java.util.Arrays;

public class TwoPointers {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int slow = 2;

        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }

    public static int[] rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Adjust k if it is larger than the length of the array.

        // Step 1: Reverse all elements in the array
        reverse(nums, 0, n - 1);
        System.out.println("nums after reverse 0, n-1: " + Arrays.toString(nums));

        // Step 2: Reverse first k elements in the array
        reverse(nums, 0, k - 1);
        System.out.println("nums after reverse 0, k-1: " + Arrays.toString(nums));

        // Step 3: Reverse the rest of the elements in the array after k
        reverse(nums, k, n - 1);
        System.out.println("nums after reverse k, n-1: " + Arrays.toString(nums));
        return nums;
    }

    private static void reverse(int[] nums, int inicio, int fin) {
        while (inicio < fin) {
            int temp = nums[inicio];
            nums[inicio] = nums[fin];
            nums[fin] = temp;
            inicio++;
            fin--;
            printArray(nums);
        }
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Rotate:");
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("nums: " + java.util.Arrays.toString(rotate(arr1, 3)));

        System.out.println("Two Pointers:");
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 5, 6, 6, 7};

        System.out.println("nums: " + java.util.Arrays.toString(nums));
        System.out.println("length of nums after removing duplicates: " + removeDuplicates(nums));
        System.out.println("nums: " + java.util.Arrays.toString(nums));
    }
}
