package com.ivansoft.java.exercises.playground.leetcode;

public class BestBuySellStock {
    public static void main(String[] args) {
        // [6,1,3,2,4,7] should be 7
        int[] prices = new int[]{6, 1, 3, 2, 4, 7};
        var result = bestBuySellStockII(prices);
        System.out.println("**********Result: " + result);

        // test 1: Prices  [1, 10, 2, 10, 3, 10, 30, 5] should be 44
        prices = new int[]{1, 10, 2, 10, 3, 10, 30, 5};
        result = bestBuySellStockII(prices);
        System.out.println("**********Result: " + result);

        // test 2: Prices [7, 1, 5, 3, 6, 4] should be 7
        prices = new int[]{7, 1, 5, 3, 6, 4};
        result = bestBuySellStockII(prices);
        System.out.println("**********Result: " + result);

        // test 3: Prices  [1, 2, 3, 4, 5] should be 4
        prices = new int[]{1, 2, 3, 4, 5};
        result = bestBuySellStockII(prices);
        System.out.println("**********Result: " + result);

        // test 4: Prices  [7, 6, 4, 3, 1] should be 0
        prices = new int[]{7, 6, 4, 3, 1};
        result = bestBuySellStockII(prices);
        System.out.println("**********Result: " + result);
    }

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
