package com.bradychiu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            // sorting takes n log(n), so we improve this by using buckets for each letter
            // char[] letters = s.toCharArray();
            // Arrays.sort(letters);
            int[] letters = new int[26];
            for (char c : s.toCharArray())
                letters[c - 'a']++;
            String key = Arrays.toString(letters);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(s);
        }

        return new ArrayList<>(groups.values());
    }
}
