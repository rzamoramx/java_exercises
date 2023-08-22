package com.java.exercises.datastructures;

import java.util.PriorityQueue;

public class MaxHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.offer(10);
        maxHeap.offer(25);
        maxHeap.offer(5);

        System.out.println(maxHeap.poll());  // Output: 25
        System.out.println(maxHeap.poll());  // Output: 10
        System.out.println(maxHeap.poll());  // Output: 5
        System.out.println(maxHeap.poll());  // Output: null
    }
}
