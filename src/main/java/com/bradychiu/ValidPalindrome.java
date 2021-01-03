package com.bradychiu;

public class ValidPalindrome {
    /**
     * time: n
     * space: 1
     */
    public static boolean isPalindromeRegex(String s) {
        if (s.length() == 0)
            return true;

        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]*", "");

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }

    public static boolean isPalindromeFaster(String s) {
        if (s.length() == 0)
            return true;

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;

            while (i < j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
            i++;
            j--;
        }

        return true;
    }
}
