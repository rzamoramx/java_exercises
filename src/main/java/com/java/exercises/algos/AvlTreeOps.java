package com.java.exercises.algos;

import com.java.exercises.datastructures.AVLTree;

public class AvlTreeOps {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);

        System.out.println("Searching 20: " + avlTree.search(20)); // Should true
        System.out.println("Searching 40: " + avlTree.search(40)); // Should false
    }
}
