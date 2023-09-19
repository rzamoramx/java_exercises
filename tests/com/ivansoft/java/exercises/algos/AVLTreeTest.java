package com.ivansoft.java.exercises.algos;

import com.ivansoft.java.exercises.datastructures.AVLTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AVLTreeTest {
    AVLTree avlTree;

    @BeforeEach
    void setUp() {
        avlTree = new AVLTree();
    }

    @Test
    void testCase1() {
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(35);
        avlTree.insert(25);
        avlTree.insert(26);
        avlTree.insert(27);
        avlTree.insert(28);

        avlTree.printTree();

        System.out.println("Searching 20: " + avlTree.search(20)); // Should true
        System.out.println("Searching 40: " + avlTree.search(40)); // Should false
    }
}
