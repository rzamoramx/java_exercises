package com.ivansoft.java.exercises.algos;

import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BreadthFirstSearch {
    public static class DefaultDict<K, V> {
        /**
         * Java pure implementation of Python's defaultdict
         */
        private final Map<K, V> map = new HashMap<>();
        private final Supplier<V> defaultValueSupplier;

        public DefaultDict(Supplier<V> defaultValueSupplier) {
            this.defaultValueSupplier = defaultValueSupplier;
        }

        public V get(K key) {
            return map.computeIfAbsent(key, k -> defaultValueSupplier.get());
        }

        public void put(K key, V value) {
            map.put(key, value);
        }
    }

    public static List<String> shortestPath(DefaultDict<String, List<String>> graph, String start, String end) {
        LinkedList<String> queue = new LinkedList<>();

        // creates a dictionary to store the parent of each node
        Map<String, String> parent = new HashMap<>();

        queue.add(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            // If we've reached the end node, reconstruct and return the path
            if (current.equals(end)) {
                List<String> path = new LinkedList<>();
                while (current != null) {
                    path.add(0, current);
                    current = parent.get(current);
                }

                return path;
            }

            // Explore neighbors
            for (String neighbor : graph.get(current)) {
                if (!parent.containsKey(neighbor)) {
                    queue.add(neighbor);
                    parent.put(neighbor, current);
                }
            }
        }

        // If no path exists from start to end
        return null;
    }
}



