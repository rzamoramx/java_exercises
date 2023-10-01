package com.ivansoft.java.exercises.playground.leetcode;

import org.junit.jupiter.api.Test;

public class RemoveDuplicatesArrayTest {
    @Test
    public void testRemoveDuplicates() {
        var input = new int[]{1, 1, 1, 2, 2, 3};
        var result = RemoveDuplicatesArray.removeDuplicates(input);
        assert result == 5;
    }
}
