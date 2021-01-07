package com.bradychiu;

public class LongestCommonPrefix {
    /**
     * time: w * L(w)
     * space: 1
     */
    public static String longestCommonPrefixVerticalScan(String[] strs) {
        if (strs.length == 0)
            return "";

        String prefix = strs[0];
        for (int charIndex = 0; charIndex < prefix.length(); charIndex++) {


            for (int wordIndex = 1; wordIndex < strs.length; wordIndex++) {
                if (charIndex >= strs[wordIndex].length()
                    || prefix.charAt(charIndex) != strs[wordIndex].charAt(charIndex))
                    return prefix.substring(0, charIndex);
            }
        }

        return prefix;
    }

    /**
     * time: w * L(w)
     * space: 1
     */
    public static String longestCommonPrefixHorizontalScan(String[] strs) {
        if (strs.length == 0)
            return "";

        String prefix = strs[0];
        for (int wordIndex = 1; wordIndex < strs.length; wordIndex++) {
            while(strs[wordIndex].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0)
                    return "";
            }
        }

        return prefix;
    }
}
