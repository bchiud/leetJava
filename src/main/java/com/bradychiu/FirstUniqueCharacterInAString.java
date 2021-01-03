package com.bradychiu;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    /**
     * time: n
     * space: 1
     */
    public static int firstUniqCharHashMap(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (counts.get(s.charAt(i)) == 1)
                return i;
        }

        return -1;
    }

    /**
     * time: n
     * space: n
     */
    public static int firstUniqCharArray(String s) {
        char[] counts = new char[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }
}
