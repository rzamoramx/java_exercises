package com.java.exercises.algos;

import com.java.exercises.datastructures.BinaryTree;

public class BinaryTreeSearch {
    public static void main(String[] args) {
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
}
