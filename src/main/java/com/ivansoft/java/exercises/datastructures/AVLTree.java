package com.ivansoft.java.exercises.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    static class Node {
        int key;
        int height;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }
    private Node root;

    public void insert(int key) {
        root = insertNode(root, key);
    }

    private Node insertNode(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insertNode(node.left, key);
        } else if (key > node.key) {
            node.right = insertNode(node.right, key);
        } else {
            // are not allowed duplicated keys in AVL Tree
            return node;
        }

        // Updates node height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // balance tree
        int balance = getBalance(node);

        // left-left case
        if (balance > 1 && key < node.left.key) {
            return rotateRight(node);
        }

        // right-right case
        if (balance < -1 && key > node.right.key) {
            return rotateLeft(node);
        }

        // left-right case
        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // right-left case
        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private int getHeight(Node node) {
        return (node == null) ? 0 : node.height;
    }

    private int getBalance(Node node) {
        return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    public boolean search(int key) {
        return searchNode(root, key);
    }

    private boolean searchNode(Node node, int key) {
        if (node == null) {
            return false;
        }

        if (key == node.key) {
            return true;
        } else if (key < node.key) {
            return searchNode(node.left, key);
        } else {
            return searchNode(node.right, key);
        }
    }

    public void printTree() {
        if (root == null) {
            System.out.println("Árbol AVL vacío.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                System.out.print(node.key + " ");

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }
}
