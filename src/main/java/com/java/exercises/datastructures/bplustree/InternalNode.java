package com.java.exercises.datastructures.bplustree;

import java.util.ArrayList;
import java.util.List;

// InternalNode class representing an internal (non-leaf) node in the B+ tree
class InternalNode extends Node {
    List<Node> children;
    int degree;

    InternalNode(int degree) {
        super();
        children = new ArrayList<>(); // Initialize the children list for internal nodes
        this.degree = degree;
    }

    void addChild(Node child) {
        children.add(child); // Add a child node to this internal node
    }

    void splitChild(int index) {
        Node child = children.get(index);
        int mid;// Insert the new node as a child

        if (child instanceof InternalNode) {
            InternalNode newNode = new InternalNode(this.degree);
            mid = child.keys.size() / 2;
            for (int i = mid; i < child.keys.size(); i++) {
                newNode.keys.add(child.keys.get(i)); // Move keys to the new node
            }

            for (int i = mid; i < child.keys.size(); i++) {
                newNode.children.add(((InternalNode) child).children.get(i)); // Move children to the new node
            }

            child.keys.subList(mid, child.keys.size()).clear();
            ((InternalNode) child).children.subList(mid, child.keys.size() + 1).clear();

            keys.add(index, newNode.keys.get(0)); // Insert a key from the new node to this node
            children.add(index + 1, newNode); // Insert the new node as a child
        } else {
            LeafNode newNode = new LeafNode(this.degree);
            mid = child.keys.size() / 2;
            for (int i = mid; i < child.keys.size(); i++) {
                newNode.keys.add(child.keys.get(i)); // Move keys to the new node
                newNode.values.add(((LeafNode) child).values.get(i)); // Move values to the new node
            }

            child.keys.subList(mid, child.keys.size()).clear();
            ((LeafNode) child).values.subList(mid, child.keys.size()).clear();

            keys.add(index, newNode.keys.get(0)); // Insert a key from the new node to this node
            children.add(index + 1, newNode); // Insert the new node as a child
        }
    }

    @Override
    void insert(int key, String value) {
        int index = 0;
        while (index < keys.size() && key >= keys.get(index)) {
            index++;
        }
        children.get(index).insert(key, value); // Insert in the appropriate child
        if (children.get(index).isOverflow()) {
            splitChild(index); // Split the child if it overflows
        }
    }

    @Override
    String search(int key) {
        int index = 0;
        while (index < keys.size() && key > keys.get(index)) {
            index++;
        }
        return children.get(index).search(key); // Search in the appropriate child
    }

    @Override
    List<String> exactSearch(int key) {
        int index = 0;
        while (index < keys.size() && key >= keys.get(index)) {
            index++;
        }
        // if index is more than keys.size() then it means that the key is greater than all the keys in the node
        if (index == keys.size()) {
            return new ArrayList<>();
        }
        return children.get(index).exactSearch(key); // Exact search in the appropriate child
    }

    @Override
    List<String> rangeQuery(int startKey, int endKey) {
        int index = 0;
        while (index < keys.size() && startKey >= keys.get(index)) {
            index++;
        }
        return children.get(index).rangeQuery(startKey, endKey); // Range query in the appropriate child
    }

    @Override
    boolean isOverflow() {
        return keys.size() >= degree; // Check if this internal node is overflowing
    }
}
