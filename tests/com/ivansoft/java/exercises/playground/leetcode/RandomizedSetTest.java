package com.ivansoft.java.exercises.playground.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RandomizedSetTest {
    @Test
    void testUsecase1() {
        /*
            Input
            ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
            [[], [1], [2], [2], [], [1], [2], []]

            Output
            [null, true, false, true, 2, true, false, 2]
         */
        RandomizedSet randomizedSet = new RandomizedSet();
        assertTrue(randomizedSet.insert(1));
        assertFalse(randomizedSet.remove(2));
        assertTrue(randomizedSet.insert(2));
        assertTrue(randomizedSet.getRandom() == 1 || randomizedSet.getRandom() == 2);
        assertTrue(randomizedSet.remove(1));
        assertFalse(randomizedSet.insert(2));
        assertTrue(randomizedSet.getRandom() == 2);
    }

    @Test
    void testInsert() {
        RandomizedSet randomizedSet = new RandomizedSet();
        assertTrue(randomizedSet.insert(1));
        assertFalse(randomizedSet.remove(1));
    }

    @Test
    void testRemove() {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        assertTrue(randomizedSet.remove(1));
        assertFalse(randomizedSet.remove(1));
    }

    @Test
    void testGetRandom() {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.insert(2);
        int random = randomizedSet.getRandom();
        assertTrue(random == 1 || random == 2);
    }
}
