package com.java.exercises.datastructures.bplustree;

import java.util.List;

// NOTE: this scratch implementation of B+ tree is wrong, only for testing purposes
class BPlusTree {
    private Node root;
    private final int degree;

    public BPlusTree(int degree) {
        this.degree = degree;
        this.root = new LeafNode(this.degree); // Initialize the B+ tree with an empty leaf node root
    }

    public void insert(int key, String value) {
        root.insert(key, value); // Start the insertion process from the root
        if (root.isOverflow()) {
            InternalNode newRoot = new InternalNode(this.degree);
            newRoot.addChild(root);
            newRoot.splitChild(0);
            root = newRoot; // If root overflows during insertion, create a new root and split the old root
        }
    }

    public String search(int key) {
        return root.search(key); // Start the search process from the root
    }

    public List<String> exactSearch(int key) {
        return root.exactSearch(key); // Start exact search from the root
    }

    public List<String> rangeQuery(int startKey, int endKey) {
        return root.rangeQuery(startKey, endKey); // Start range query from the root
    }
}

