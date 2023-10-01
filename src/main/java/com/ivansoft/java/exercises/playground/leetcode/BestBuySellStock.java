package com.ivansoft.java.exercises.playground.leetcode;

public class BestBuySellStock {
    static int bestBuySellStockII(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int maxProfit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}
