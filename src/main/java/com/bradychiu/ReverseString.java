package com.bradychiu;

public class ReverseString {
    /**
     * time: n / 2
     * space: 1
     */
    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = tmp;
        }
    }
}
