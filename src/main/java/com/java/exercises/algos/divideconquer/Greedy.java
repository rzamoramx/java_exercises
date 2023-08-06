
package com.java.exercises.algos.divideconquer;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy {
    public static double knapsackGreedy(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        Item[] items = new Item[n];

        // An array of items with weights and values.
        for (int i = 0; i < n; i++) {
            items[i] = new Item(weights[i], values[i]);
        }

        // order items by values and weights, desc.
        Arrays.sort(items, Comparator.comparingDouble(Item::getValuePerWeight).reversed());

        double totalValue = 0;
        int remainingCapacity = capacity;

        for (Item item : items) {
            if (item.getWeight() <= remainingCapacity) {
                totalValue += item.getValue();
                remainingCapacity -= item.getWeight();
            } else {
                // If object can't be picked whole, pick the remaining weight
                totalValue += (item.getValuePerWeight() * remainingCapacity);
                break;
            }
        }

        return totalValue;
    }

    public static class Item {
        private int weight;
        private int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public int getValue() {
            return value;
        }

        public double getValuePerWeight() {
            return (double) value / weight;
        }
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;

        double maxValue = knapsackGreedy(weights, values, capacity);
        System.out.println("Maximum value that can be put in knapsack: " + maxValue);
    }
}
