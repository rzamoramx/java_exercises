package com.ivansoft.java.exercises.playground.leetcode;

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
}
