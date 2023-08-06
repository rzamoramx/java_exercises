package com.java.exercises.concurrencyparalelism;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafetyAndConcurrentDataStructures {
    // Example with synchronized methods
    static class SynchronizedCounter {
        private int value = 0;

        // Synchronized method to increment the counter
        public synchronized void increment() {
            value++;
        }

        // Synchronized method to get the current value of the counter
        public synchronized int getValue() {
            return value;
        }
    }

    // Example with Locks
    static class LockCounter {
        private int value = 0;
        private Lock lock = new ReentrantLock();

        // Method using Lock to increment the counter
        public void increment() {
            lock.lock();
            try {
                value++;
            } finally {
                lock.unlock();
            }
        }

        // Method using Lock to get the current value of the counter
        public int getValue() {
            lock.lock();
            try {
                return value;
            } finally {
                lock.unlock();
            }
        }
    }

    // Example with Atomic Variables (AtomicInteger)
    static class AtomicCounter {
        private AtomicInteger value = new AtomicInteger(0);

        // Method using AtomicInteger to increment the counter
        public void increment() {
            value.incrementAndGet();
        }

        // Method using AtomicInteger to get the current value of the counter
        public int getValue() {
            return value.get();
        }
    }

    // Example of ConcurrentHashMap
    static class ConcurrentMapExample {
        public static void main(String[] args) {
            ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

            // Adding key-value pairs to the ConcurrentHashMap
            map.put("A", 1);
            map.put("B", 2);
            map.put("C", 3);

            // Iterating over the ConcurrentHashMap safely
            map.forEach((key, value) -> System.out.println(key + ": " + value));

            // Another example of safe concurrent operation on the ConcurrentHashMap
            int result = map.compute("A", (key, value) -> value + 10);
            System.out.println("Result: " + result);
        }
    }

    // Example of CopyOnWriteArrayList
    static class CopyOnWriteArrayListExample {
        public static void main(String[] args) {
            List<String> list = new CopyOnWriteArrayList<>();

            // Adding elements to the CopyOnWriteArrayList
            list.add("Java");
            list.add("Python");
            list.add("C++");

            // Iterating over the CopyOnWriteArrayList safely (concurrent read without blocking)
            for (String item : list) {
                System.out.println(item);
            }
        }
    }

    // Example of BlockingQueue (LinkedBlockingQueue)
    static class BlockingQueueExample {
        public static void main(String[] args) {
            BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);

            // Enqueuing (adding) elements to the BlockingQueue
            queue.offer("Item 1");
            queue.offer("Item 2");
            queue.offer("Item 3");

            // Dequeuing (removing) elements from the BlockingQueue
            String item1 = queue.poll();
            String item2 = queue.poll();
            String item3 = queue.poll();

            // Printing the dequeued items
            System.out.println(item1);
            System.out.println(item2);
            System.out.println(item3);
        }
    }

    public static void main(String[] args) {
        // Example of thread safety with synchronized methods
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        synchronizedCounter.increment();
        System.out.println("Synchronized Method: " + synchronizedCounter.getValue());

        // Example of thread safety with Locks
        LockCounter lockCounter = new LockCounter();
        lockCounter.increment();
        System.out.println("Lock: " + lockCounter.getValue());

        // Example of thread safety with Atomic Variables
        AtomicCounter atomicCounter = new AtomicCounter();
        atomicCounter.increment();
        System.out.println("Atomic Variable: " + atomicCounter.getValue());

        // Example of ConcurrentHashMap
        ConcurrentMapExample.main(args);

        // Example of CopyOnWriteArrayList
        CopyOnWriteArrayListExample.main(args);

        // Example of BlockingQueue (LinkedBlockingQueue)
        BlockingQueueExample.main(args);
    }
}

