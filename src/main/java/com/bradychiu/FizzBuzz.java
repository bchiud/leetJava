package com.bradychiu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FizzBuzz {
    /**
     * time: n
     * space: 1
     */
    public List<String> fizzBuzzStandard(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }

    public List<String> fizzBuzzScalable(int n) {
        Map<Integer, String> int2Word = new HashMap<>();
        int2Word.put(3, "Fizz");
        int2Word.put(5, "Buzz");

        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder curStringBuilder = new StringBuilder();
            for (int j : int2Word.keySet()) {
                if (i % j == 0) {
                    curStringBuilder.append(int2Word.get(j));
                }
            }
            if (curStringBuilder.length() == 0) {
                curStringBuilder.append(String.valueOf(i));
            }
            ans.add(curStringBuilder.toString());
        }

        return ans;
    }
}
