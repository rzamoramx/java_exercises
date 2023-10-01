package com.ivansoft.java.exercises.playground.leetcode;

import org.junit.jupiter.api.Test;

public class JumpGameTest {
    @Test
    void testUseCase1JumpGameV1() {
        var nums = new int[]{2, 3, 1, 1, 4};
        var result = JumpGame.jumpGame(nums);
        assert result;
    }

    @Test
    void testUseCase2JumpGameV1() {
        var nums = new int[]{3, 2, 1, 0, 4};
        var result = JumpGame.jumpGame(nums);
        assert !result;
    }

    @Test
    void testUseCase3JumpGameV1() {
        var nums = new int[]{0};
        var result = JumpGame.jumpGame(nums);
        assert result;
    }

    @Test
    void testUseCase4JumpGameV1() {
        var nums = new int[]{1, 2};
        var result = JumpGame.jumpGame(nums);
        assert result;
    }

    @Test
    void testUseCase5JumpGameV1() {
        var nums = new int[]{2, 0};
        var result = JumpGame.jumpGame(nums);
        assert result;
    }

    @Test
    void testUseCase6JumpGameV1() {
        var nums = new int[]{0, 2, 3};
        var result = JumpGame.jumpGame(nums);
        assert !result;
    }

    @Test
    void testUseCase7JumpGameV1() {
        var nums = new int[]{2, 5, 0, 0};
        var result = JumpGame.jumpGame(nums);
        assert result;
    }

    @Test
    void testUseCase8JumpGameV1() {
        var nums = new int[]{1, 1, 2, 2, 0, 1, 1};
        var result = JumpGame.jumpGame(nums);
        assert result;
    }

    @Test
    void testUseCase1JumpGameV2() {
        var nums = new int[]{2, 3, 1, 1, 4};
        var result = JumpGame.jumpII(nums);
        assert result == 2;
    }

    @Test
    void testUseCase2JumpGameV2() {
        var nums = new int[]{2, 3, 0, 1, 4};
        var result = JumpGame.jumpII(nums);
        assert result == 2;
    }
}
