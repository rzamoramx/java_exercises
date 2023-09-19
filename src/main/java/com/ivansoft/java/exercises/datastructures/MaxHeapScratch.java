package com.ivansoft.java.exercises.datastructures;

public class MaxHeapScratch {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeapScratch(int capacity) {
        this.heap = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full.");
            return;
        }
        heap[size] = value;
        size++;
        heapifyUp();
    }

    public int popMax() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1;
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return max;
    }

    private void heapifyUp() {
        int index = size - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap[index] > heap[parentIndex]) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (index < size) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int largestIndex = index;

            if (leftChildIndex < size && heap[leftChildIndex] > heap[largestIndex]) {
                largestIndex = leftChildIndex;
            }
            if (rightChildIndex < size && heap[rightChildIndex] > heap[largestIndex]) {
                largestIndex = rightChildIndex;
            }

            if (largestIndex != index) {
                swap(index, largestIndex);
                index = largestIndex;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
