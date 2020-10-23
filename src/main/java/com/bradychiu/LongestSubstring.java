package com.bradychiu;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1)
            return len;

        Map<Character, Integer> charPos = new HashMap<>();
        int startPos = 0;
        int maxLength = 1;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (charPos.containsKey(c))
                startPos = Math.max(startPos, charPos.get(c) + 1);
            charPos.put(c, i);
            maxLength = Math.max(maxLength, i - startPos + 1);
        }
        return maxLength;
    }
}
