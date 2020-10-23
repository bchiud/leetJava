package com.bradychiu;

public class LongestPalindrome {

    // time: n^2
    // space: 1
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int left = i;
            int right = i;

            while (left >= 0 && s.charAt(left) == c)
                left--;

            while (right < len && s.charAt(right) == c)
                right++;

            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            left++;
            if (end - start < right - left) {
                start = left;
                end = right;
            }
        }

        return s.substring(start, end);
    }
}
