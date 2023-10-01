package com.ivansoft.java.exercises.playground.leetcode;

import org.junit.jupiter.api.Test;

public class HindexTest {
    @Test
    void testUseCase1() {
        //citations = [3,0,6,1,5]
        int[] citations = new int[]{3, 0, 6, 1, 5};
        int result = HIndex.getSolution(citations);
        assert result == 3;
    }

    @Test
    void testUseCase2() {
        //citations = [1,3,1]
        int[] citations = new int[]{1, 3, 1};
        int result = HIndex.getSolution(citations);
        assert result == 1;
    }
}
