package com.ivansoft.java.exercises.playground.leetcode;

import org.junit.jupiter.api.Test;

public class CandiesTest {
    @Test
    void testUseCase1() {
        var input = new int[]{1, 0, 2};
        var result = Candies.candy(input);
        assert result == 5;
    }

    @Test
    void testUseCase2() {
        var input = new int[]{1, 2, 2};
        var result = Candies.candy(input);
        assert result == 4;
    }

    @Test
    void testUseCase3() {
        var input = new int[]{1, 2, 87, 87, 87, 2, 1};
        var result = Candies.candy(input);
        assert result == 13;
    }

    @Test
    void testUseCase4() {
        var input = new int[]{1, 3, 4, 5, 2};
        var result = Candies.candy(input);
        assert result == 11;
    }
}
