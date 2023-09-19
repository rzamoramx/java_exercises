package com.ivansoft.java.exercises.algos;

import org.junit.jupiter.api.Test;

import java.util.List;

public class BreadthFirstSearchTest {
    @Test
    void testBreadthFirstSearch() {
        BreadthFirstSearch.DefaultDict<String, List<String>> graph = new BreadthFirstSearch.DefaultDict<>(List::of);
        graph.put("A", List.of("B", "C", "D"));
        graph.put("B", List.of("A", "E", "F"));
        graph.put("C", List.of("A"));
        graph.put("D", List.of("A", "G"));
        graph.put("E", List.of("B"));
        graph.put("F", List.of("B"));
        graph.put("G", List.of("D"));

        String startNode = "A";
        String endNode = "G";

        List<String> shortestPath = BreadthFirstSearch.shortestPath(graph, startNode, endNode);

        if (shortestPath != null) {
            System.out.println("Shortest path from " + startNode + " to " + endNode + " is: " + shortestPath);
        } else {
            System.out.println("No path from " + startNode + " to " + endNode + " exists");
        }
    }
}
