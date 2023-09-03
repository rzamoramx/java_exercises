package com.java.exercises.playground.leetcode;


class RemoveDuplicatesArray {
    public static void main(String[] args) {
        var input = new int[]{1, 1, 1, 2, 2, 3};
        var result = removeDuplicates(input);
        System.out.println("**********Result: " + result);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;

        var k = 2;
        var count = 1;
        var slow = 1;

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] == nums[fast - 1]) {
                count++;
            }
            else {
                count = 1;
            }

            if (count <= k) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }
}