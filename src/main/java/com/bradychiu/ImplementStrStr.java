package com.bradychiu;

public class ImplementStrStr {
    /**
     * time: (haystack.length - needle.length) * needle.length
     * space: 1
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        int h = 0;
        int n = 0;
        while (h + needle.length() <= haystack.length() && n < needle.length()) {
            while (h < haystack.length() && haystack.charAt(h) != needle.charAt(n)) {
                h++;
            }

            int hCheck = h;
            while (hCheck < haystack.length() && n < needle.length()
                    && haystack.charAt(hCheck) == needle.charAt(n)) {
                hCheck++;
                n++;
            }
            if (n >= needle.length())
                return h;

            n = 0;
            h++;
        }

        return -1;
    }
}
