package com.ivansoft.java.exercises.datastructures;

import org.junit.jupiter.api.Test;

public class MaxMaxHeapScratchTest {
    @Test
    void testSimpleMaxHeap() {
        MaxHeapScratch maxHeap = new MaxHeapScratch(10);
        maxHeap.insert(10);
        maxHeap.insert(25);
        maxHeap.insert(5);

        System.out.println(maxHeap.popMax());  // Output: 25
        System.out.println(maxHeap.popMax());  // Output: 10
        System.out.println(maxHeap.popMax());  // Output: 5
        System.out.println(maxHeap.popMax());  // Output: -1
    }
}
