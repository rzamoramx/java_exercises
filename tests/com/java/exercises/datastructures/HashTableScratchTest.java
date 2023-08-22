package com.java.exercises.datastructures;

import org.junit.jupiter.api.Test;

public class HashTableScratchTest {
    @Test
    void testSimpleOperation() {
        HashTableScratch<String, Integer> hashTable = new HashTableScratch<>(10);
        hashTable.insert("apple", 5);
        hashTable.insert("banana", 8);
        hashTable.insert("cherry", 12);

        System.out.println(hashTable.get("apple"));  // Output: 5
        System.out.println(hashTable.get("banana")); // Output: 8
        System.out.println(hashTable.get("grape"));  // Output: null
    }
}
