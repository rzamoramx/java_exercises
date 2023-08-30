package com.java.exercises.algos;

import org.junit.jupiter.api.Test;

import java.util.*;

public class DijkstraTest {
    @Test
    void testExample() {
        Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new Pair<>(3, 7), new Pair<>(4, 6)));
        graph.put(1, Collections.singletonList(new Pair<>(5, 8)));
        graph.put(2, Arrays.asList(new Pair<>(0, 9), new Pair<>(6, 4)));
        graph.put(3, Collections.singletonList(new Pair<>(7, 3)));
        graph.put(4, Collections.singletonList(new Pair<>(7, 5)));
        graph.put(5, Collections.emptyList());
        graph.put(6, Arrays.asList(new Pair<>(2, 5), new Pair<>(5, 1)));
        graph.put(7, Collections.emptyList());

        int startNode = 0;
        Map<Integer, Integer> distances = Dijkstra.run(graph, startNode);

        for (int node : distances.keySet()) {
            System.out.println("Distance from node " + startNode + " to node " + node + ": " + distances.get(node));
        }
    }
}
