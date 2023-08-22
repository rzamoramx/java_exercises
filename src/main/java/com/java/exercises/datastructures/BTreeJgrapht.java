package com.java.exercises.datastructures;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

public class BTreeJgrapht {
    public static void main(String[] args) {
        // Creates a graph
        SimpleGraph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        // Add nodes
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        // Add edges
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");

        // Makes a Breadth First Iterator
        BreadthFirstIterator<String, DefaultEdge> iterator = new BreadthFirstIterator<>(graph, "A");
        while (iterator.hasNext()) {
            String vertex = iterator.next();
            System.out.println(vertex);
        }
    }
}
