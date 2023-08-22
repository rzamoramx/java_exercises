package com.java.exercises.datastructures.bplustree;

import java.util.ArrayList;
import java.util.List;

// LeafNode class representing a leaf node in the B+ tree
class LeafNode extends Node {
    List<String> values;
    int degree;

    LeafNode(int degree) {
        super();
        values = new ArrayList<>(); // Initialize the values list for leaf nodes
        this.degree = degree;
    }

    @Override
    void insert(int key, String value) {
        int index = 0;
        while (index < keys.size() && key >= keys.get(index)) {
            index++;
        }
        keys.add(index, key); // Insert the key at the appropriate position
        values.add(index, value); // Insert the value at the appropriate position
    }

    @Override
    String search(int key) {
        int index = 0;
        while (index < keys.size() && key > keys.get(index)) {
            index++;
        }
        if (index < keys.size() && key == keys.get(index)) {
            return values.get(index); // If key is found, return the corresponding value
        }
        return null; // Key not found
    }

    @Override
    List<String> exactSearch(int key) {
        List<String> results = new ArrayList<>();
        int index = 0;
        while (index < keys.size() && key > keys.get(index)) {
            index++;
        }
        while (index < keys.size() && key == keys.get(index)) {
            results.add(values.get(index)); // Collect all values with the exact key match
            index++;
        }
        return results;
    }

    @Override
    List<String> rangeQuery(int startKey, int endKey) {
        List<String> results = new ArrayList<>();
        int index = 0;
        while (index < keys.size() && startKey > keys.get(index)) {
            index++;
        }
        while (index < keys.size() && startKey <= keys.get(index) && keys.get(index) <= endKey) {
            results.add(values.get(index)); // Collect values within the specified range
            index++;
        }
        return results;
    }

    @Override
    boolean isOverflow() {
        return keys.size() >= degree; // Check if this leaf node is overflowing
    }
}
