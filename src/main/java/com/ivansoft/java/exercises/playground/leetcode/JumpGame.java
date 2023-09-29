package com.ivansoft.java.exercises.playground.leetcode;

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        var nums = new int[]{2, 3, 1, 1, 4};
        var result = jumpGame(nums);
        System.out.println("**********Result: " + result); // true

        nums = new int[]{3, 2, 1, 0, 4};
        result = jumpGame(nums);
        System.out.println("**********Result: " + result); // false

        nums = new int[]{0};
        result = jumpGame(nums);
        System.out.println("**********Result: " + result); // true

        nums = new int[]{1, 2};
        result = jumpGame(nums);
        System.out.println("**********Result: " + result); // true

        nums = new int[]{2, 0};
        result = jumpGame(nums);
        System.out.println("**********Result: " + result); // true

        nums = new int[]{0, 2, 3};
        result = jumpGame(nums);
        System.out.println("**********Result: " + result); // false

        nums = new int[]{2, 5, 0, 0};
        result = jumpGame(nums);
        System.out.println("**********Result: " + result); // true

        nums = new int[]{1, 1, 2, 2, 0, 1, 1};
        result = jumpGame(nums);
        System.out.println("**********Result: " + result); // true

        System.out.println("**********Jump Game II**********");

        JumpGame solution = new JumpGame();
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {2, 3, 0, 1, 4};

        System.out.println(solution.jumpII(nums1)); // Output: 2
        System.out.println(solution.jumpII(nums2)); // Output: 2
    }

    public static boolean jumpGame(int[] nums) {
        int n = nums.length;
        boolean[] canJump = new boolean[n];
        canJump[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {
            int maxJump = Math.min(i + nums[i], n - 1);
            System.out.println("i: " + i + ", maxJump: " + maxJump + ", nums[i]: " + nums[i]);
            for (int j = i + 1; j <= maxJump; j++) {
                System.out.println("j: " + j + ", canJump[j]: " + canJump[j]);
                if (canJump[j]) {
                    canJump[i] = true;
                    break;
                }
            }
        }

        return canJump[0];
    }

    public static int jumpII(int[] nums) {
        /*
        we use greedy algorithm to solve this problem.
        in greedy we find for local optimal solution and then we move to the next step.
        jumps keeps track of the minimum number of jumps required to reach the end.
        currentEnd represents the farthest index you can reach with the current number of jumps.
        farthest represents the farthest index you can reach with one more jump.
        We iterate through the array, updating farthest to keep track of the maximum reachable index for the next jump.
        When we reach the currentEnd, we increment jumps and update currentEnd to farthest to make a jump.
        Finally, we return the value of jumps as the minimum number of jumps required to reach the end.

        The time complexity of this algorithm is O(n), where n is the length of the nums array, making it an efficient solution for this problem.
         */
        int n = nums.length;
        int jumps = 0;
        int currentEnd = 0;  // The farthest index you can reach with the current jump
        int farthest = 0;    // The farthest index you can reach with one more jump

        // print the content of nums array
        System.out.println("nums: " + Arrays.toString(nums));

        for (int i = 0; i < n - 1; i++) {
            System.out.println("i: " + i + ", currentEnd: " + currentEnd + ", farthest: " + farthest);
            farthest = Math.max(farthest, i + nums[i]);
            System.out.println("i: " + i + ", farthest: " + farthest + ", nums[i]: " + nums[i]);

            // If we have reached the currentEnd, we need to make a jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                System.out.println("i: " + i + ", jumps: " + jumps + ", currentEnd: " + currentEnd);
            }
        }

        return jumps;
    }
}
