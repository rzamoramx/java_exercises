package com.java.exercises.algos;

import java.util.*;

public class Dijkstra {
    public static Map<Integer, Integer> run(Map<Integer, List<Pair<Integer, Integer>>> graph, int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Pair::second));

        for (int node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        distances.put(start, 0);
        priorityQueue.add(new Pair<>(start, 0));

        while (!priorityQueue.isEmpty()) {
            Pair<Integer, Integer> current = priorityQueue.poll();
            int currentNode = current.first();
            int currentDistance = current.second();

            if (currentDistance > distances.get(currentNode)) {
                continue;
            }

            for (Pair<Integer, Integer> neighbor : graph.get(currentNode)) {
                int neighborNode = neighbor.first();
                int neighborWeight = neighbor.second();
                int distanceThroughCurrent = currentDistance + neighborWeight;

                if (distanceThroughCurrent < distances.get(neighborNode)) {
                    distances.put(neighborNode, distanceThroughCurrent);
                    priorityQueue.add(new Pair<>(neighborNode, distanceThroughCurrent));
                }
            }
        }

        return distances;
    }
}

record Pair<K, V>(K first, V second) {
}
