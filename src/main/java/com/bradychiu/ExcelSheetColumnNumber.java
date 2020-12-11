package com.bradychiu;

public class ExcelSheetColumnNumber {
    /**
     * time: n = s.length()
     * space: 1
     */

    public static int titleToNumberFull(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n += (s.charAt(i) - '@') * Math.pow(26, s.length() - i - 1);
        }
        return n;
    }

    public static int titleToNumber(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n = n * 26 + s.charAt(i) - '@';
        }
        return n;
    }

    public static int titleToNumberOneLiner(String s) {
        return s.length() != 0 ? 26 * titleToNumberOneLiner(s.substring(0, s.length() - 1)) + s.charAt(s.length() - 1) - '@' : 0;
    }

    public static int titleToNumberJava8(String s) {
        return s.chars().reduce( 0, (r, ch) -> r * 26 + (ch - '@'));
    }

}
