package com.ivansoft.java.exercises.playground.leetcode;

import org.junit.jupiter.api.Test;

import static com.ivansoft.java.exercises.playground.leetcode.BestBuySellStock.bestBuySellStockII;

public class BestBuySellStockTest {
    @Test
    void testUseCase1() {
        // [6,1,3,2,4,7] should be 7
        int[] prices = new int[]{6, 1, 3, 2, 4, 7};
        var result = bestBuySellStockII(prices);
        assert result == 7;
    }

    @Test
    void testUseCase2() {
        // Prices  [1, 10, 2, 10, 3, 10, 30, 5] should be 44
        int[] prices = new int[]{1, 10, 2, 10, 3, 10, 30, 5};
        var result = bestBuySellStockII(prices);
        assert result == 44;
    }

    @Test
    void testUseCase3() {
        // Prices [7, 1, 5, 3, 6, 4] should be 7
        int[]  prices = new int[]{7, 1, 5, 3, 6, 4};
        var result = bestBuySellStockII(prices);
        assert result == 7;
    }

    @Test
    void testUseCase4() {
        // test 3: Prices  [1, 2, 3, 4, 5] should be 4
        int[] prices = new int[]{1, 2, 3, 4, 5};
        var result = bestBuySellStockII(prices);
        assert result == 4;
    }

    @Test
    void testUseCase5() {
        // test 4: Prices  [7, 6, 4, 3, 1] should be 0
        int[] prices = new int[]{7, 6, 4, 3, 1};
        var result = bestBuySellStockII(prices);
        assert result == 0;
    }
}
