package com.bradychiu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    private List<Integer> vals;
    private Map<Integer, Integer> dupCheck;
    private Random r;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        dupCheck = new HashMap<>();
        vals = new ArrayList<>();
        r = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     * time: 1
     * space: 1
     */
    public boolean insert(int val) {
        if (dupCheck.containsKey(val))
            return false;

        dupCheck.put(val, vals.size());
        vals.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     * time: 1
     * space: 1
     */
    public boolean remove(int val) {
        if (!dupCheck.containsKey(val))
            return false;

        int i = dupCheck.remove(val);

        if (i != vals.size() - 1) {
            vals.set(i, vals.get(vals.size() - 1));
            dupCheck.put(vals.get(i), i);
        }

        vals.remove(vals.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     * time: 1
     * space: 1
     */
    public int getRandom() {
        return vals.get(r.nextInt(vals.size()));
    }

}
