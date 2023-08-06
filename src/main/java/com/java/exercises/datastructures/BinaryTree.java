package com.java.exercises.datastructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    private Node root;

    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(int value) {
        root = insertRecursively(root, value);
    }

    private Node insertRecursively(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = insertRecursively(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursively(current.right, value);
        }

        return current;
    }

    public boolean contains(int value) {
        return containsRecursively(root, value);
    }

    private boolean containsRecursively(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        } else if (value < current.value) {
            return containsRecursively(current.left, value);
        } else {
            return containsRecursively(current.right, value);
        }
    }

    public int size() {
        return sizeRecursively(root);
    }

    private int sizeRecursively(Node current) {
        if (current == null) {
            return 0;
        }

        return 1 + sizeRecursively(current.left) + sizeRecursively(current.right);
    }

    public void delete(int value) {
        root = deleteRecursively(root, value);
    }

    private Node deleteRecursively(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node to be deleted found

            // Case 1: Node with only one child or no child
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            // Case 2: Node with two children
            current.value = findMinValue(current.right);
            current.right = deleteRecursively(current.right, current.value);
        } else if (value < current.value) {
            current.left = deleteRecursively(current.left, value);
        } else {
            current.right = deleteRecursively(current.right, value);
        }

        return current;
    }

    private int findMinValue(Node node) {
        int minValue = node.value;
        while (node.left != null) {
            minValue = node.left.value;
            node = node.left;
        }
        return minValue;
    }

    public void print() {
        if (root == null) {
            System.out.println("Binary Tree is empty.");
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            int levelSize = stack.size();
            for (int i = 0; i < levelSize; i++) {
                Node current = stack.pop();
                System.out.print(current.value + " ");

                // Push the right child first, so the left child is processed first (since it's a stack)
                if (current.right != null) {
                    stack.push(current.right);
                }

                if (current.left != null) {
                    stack.push(current.left);
                }
            }

            System.out.println(); // Newline after each level
        }
    }
}
