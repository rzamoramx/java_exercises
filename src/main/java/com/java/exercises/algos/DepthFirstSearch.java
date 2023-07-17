package com.java.exercises.algos;

import java.util.LinkedList;

public class DepthFirstSearch {
    public void search(Node startNode) {
        System.out.println("DFS traversal starting from node: " + startNode.name);
        recursiveDFS(startNode);
    }

    private void recursiveDFS(Node currentNode) {
        System.out.println("Visiting node: " + currentNode.name);
        currentNode.visited = true;

        for (Node neighbor : currentNode.getNeighbors()) {
            if (!neighbor.visited) {
                recursiveDFS(neighbor);
            }
        }
    }
}

class Graph {
    private LinkedList<Node> nodes;

    public Graph() {
        this.nodes = new LinkedList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    // draw horizontally a graph, use -> to indicate a neighbor
    public void drawAsTree() {
        if (nodes.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }

        Node rootNode = nodes.get(0);
        drawNodeAsTree(rootNode, "");
    }

    private void drawNodeAsTree(Node node, String prefix) {
        System.out.println(prefix + "|_" + node.name);

        LinkedList<Node> neighbors = node.getNeighbors();
        for (int i = 0; i < neighbors.size(); i++) {
            Node neighbor = neighbors.get(i);
            if (i == neighbors.size() - 1) {
                drawNodeAsTree(neighbor, prefix + "    ");
            } else {
                drawNodeAsTree(neighbor, prefix + "|   ");
            }
        }
    }
}

class Node {
    String name;
    LinkedList<Node> neighbors;
    boolean visited;

    public Node(String name) {
        this.name = name;
        this.neighbors = new LinkedList<>();
        this.visited = false;
    }

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }

    public LinkedList<Node> getNeighbors() {
        return neighbors;
    }
}

