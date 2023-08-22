package com.java.exercises.datastructures.bplustree;

import org.junit.jupiter.api.Test;

public class BPlusTreeTest {
    @Test
    void testInsertSearch() {
        BPlusTree bPlusTree = new BPlusTree(3); // Create a B+ tree with degree 3

        // Insert key-value pairs
        bPlusTree.insert(10, "Value 10");
        bPlusTree.insert(5, "Value 5");
        bPlusTree.insert(15, "Value 15");
        bPlusTree.insert(3, "Value 3");
        bPlusTree.insert(8, "Value 8");
        bPlusTree.insert(12, "Value 12");

        // Search for keys
        System.out.println("Search result for key 5: " + bPlusTree.search(5));
        System.out.println("Search result for key 12: " + bPlusTree.search(12));
        System.out.println("Search result for key 7: " + bPlusTree.search(7));

        // Exact search for keys
        System.out.println("Exact search result for key 10: " + bPlusTree.exactSearch(10));
        System.out.println("Exact search result for key 3: " + bPlusTree.exactSearch(3));
        System.out.println("Exact search result for key 15: " + bPlusTree.exactSearch(15));

        // Range query
        System.out.println("Range query result for keys 5 to 12: " + bPlusTree.rangeQuery(5, 12));
        System.out.println("Range query result for keys 8 to 15: " + bPlusTree.rangeQuery(8, 15));
    }
}
