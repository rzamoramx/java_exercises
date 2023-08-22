package com.java.exercises.datastructures;

import org.junit.jupiter.api.Test;

public class BTreeTest {
    @Test
    void testInsertSearch() {
        BTree bTree = new BTree(3);

        int[] keys = { 10, 20, 5, 6, 12, 30, 7, 17 };

        for (int key : keys) {
            bTree.insert(key);
        }

        System.out.println("Search for 6: " + bTree.search(6)); // Should print true
        System.out.println("Search for 21: " + bTree.search(21)); // Should print false

        bTree.delete(10);
        System.out.println("Search for 10 after deletion: " + bTree.search(10)); // Should print false
    }
}
