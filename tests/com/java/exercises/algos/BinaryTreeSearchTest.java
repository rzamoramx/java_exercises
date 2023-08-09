package com.java.exercises.algos;

import com.java.exercises.algos.divideconquer.BinarySearch;
import com.java.exercises.datastructures.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeSearchTest {
    BinarySearch binarySearch;

    @BeforeEach
    void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    void testSearchCase2() {
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(6);
        tree.insert(30);
        tree.insert(5);
        tree.insert(6);
        tree.insert(22);
        tree.insert(50);
        tree.insert(11);
        tree.insert(14);

        tree.print();
    }

    @Test
    void search() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int target = 2;
        int expected = 1;

        int result = binarySearch.search(array, target);
        assertEquals(expected, result);
    }
}