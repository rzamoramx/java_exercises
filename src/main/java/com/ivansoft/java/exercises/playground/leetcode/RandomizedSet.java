package com.ivansoft.java.exercises.playground.leetcode;

import java.util.HashSet;
import java.util.Set;

class RandomizedSet {
    Set<String> set = new HashSet<>();

    public RandomizedSet() {}

    public boolean insert(int val) {
        String valStr = String.valueOf(val);
        if (set.contains(valStr)) {
            return false;
        }
        else {
            set.add(valStr);
            return true;
        }
    }

    public boolean remove(int val) {
        String valStr = String.valueOf(val);
        if (set.contains(valStr)) {
            set.remove(valStr);
            return true;
        }
        else {
            return false;
        }
    }

    public int getRandom() {
        int random = (int) (Math.random() * set.size());
        return Integer.parseInt((String) set.toArray()[random]);
    }
}
