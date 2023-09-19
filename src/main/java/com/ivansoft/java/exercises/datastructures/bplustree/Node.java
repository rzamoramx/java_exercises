package com.ivansoft.java.exercises.datastructures.bplustree;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing a node in the B+ tree
abstract class Node {
    List<Integer> keys;

    Node() {
        keys = new ArrayList<>(); // Initialize the keys list for the node
    }

    abstract void insert(int key, String value); // Insert a key-value pair into the node
    abstract String search(int key); // Search for a key in the node
    abstract List<String> exactSearch(int key); // Search for exact matches in the node
    abstract List<String> rangeQuery(int startKey, int endKey); // Perform a range query in the node
    abstract boolean isOverflow(); // Check if the node is overflowing
}
