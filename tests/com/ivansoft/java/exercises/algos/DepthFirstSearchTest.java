package com.ivansoft.java.exercises.algos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DepthFirstSearchTest {
    DepthFirstSearch depthFirstSearch;

    @BeforeEach
    void setUp() {
        depthFirstSearch = new DepthFirstSearch();
    }

    @Test
    void searchCase2() {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");

        // Add edges: A -> B
        A.neighbors.add(B);
        // B -> G, B -> C, B -> D
        B.neighbors.add(G);
        B.neighbors.add(C);
        B.neighbors.add(D);
        // C -> D
        C.neighbors.add(D);
        // D -> E
        D.neighbors.add(E);
        // E -> F, E -> G
        E.neighbors.add(F);
        E.neighbors.add(G);
        // G -> H
        G.neighbors.add(H);

        Graph graph = new Graph();

        // Agregar nodos al grafo
        graph.addNode(A);
        graph.addNode(B);
        graph.addNode(C);
        graph.addNode(D);
        graph.addNode(E);
        graph.addNode(F);
        graph.addNode(G);
        graph.addNode(H);

        graph.drawAsTree();
        depthFirstSearch.search(A);
    }

    @Test
    void searchCase1() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addNeighbor(nodeB);
        nodeA.addNeighbor(nodeC);
        nodeB.addNeighbor(nodeD);
        nodeB.addNeighbor(nodeE);
        nodeC.addNeighbor(nodeF);
        nodeE.addNeighbor(nodeF);

        Graph graph = new Graph();

        // Agregar nodos al grafo
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph.drawAsTree();
        depthFirstSearch.search(nodeA);
    }

    @Test
    void search() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        // Establecer relaciones entre los nodos
        nodeA.addNeighbor(nodeB);
        nodeA.addNeighbor(nodeC);
        nodeB.addNeighbor(nodeD);
        nodeB.addNeighbor(nodeE);
        nodeC.addNeighbor(nodeF);

        // Crear grafo
        Graph graph = new Graph();

        // Agregar nodos al grafo
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph.drawAsTree();
        depthFirstSearch.search(nodeA);
    }
}