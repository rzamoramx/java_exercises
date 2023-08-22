package com.java.exercises.datastructures;

import java.util.HashMap;

public class HashTable {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("apple", 5);
        hashMap.put("banana", 8);
        hashMap.put("cherry", 12);

        System.out.println(hashMap.get("apple"));  // Output: 5
        System.out.println(hashMap.get("banana")); // Output: 8
        System.out.println(hashMap.get("grape"));  // Output: null
    }
}
