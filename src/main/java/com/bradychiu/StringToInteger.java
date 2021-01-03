package com.bradychiu;

public class StringToInteger {
    /**
     * time: n
     * space: 1
     * <p>
     * 1) clear leading whitespace
     * 2) optional plus minus
     * 3) digits
     * 4) remove trailing characters
     */
    public static int myAtoi(String s) {
        if (s.length() == 0)
            return 0;

        int i = 0;
        while (i < s.length() && Character.isWhitespace(s.charAt(i)))
            i++;

        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        int num = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int nextDigit = Integer.valueOf(s.charAt(i) - '0');
            if (sign == -1 && (
                    sign * num < Integer.MIN_VALUE / 10
                            || (sign * num == Integer.MIN_VALUE / 10 && nextDigit > 8)
            ))
                return Integer.MIN_VALUE;
            if (sign == 1 && (
                    num > Integer.MAX_VALUE / 10
                            || (num == Integer.MAX_VALUE / 10 && nextDigit > 7)
            ))
                return Integer.MAX_VALUE;

            num = num * 10 + nextDigit;
            i++;
        }

        return sign * num;
    }

    public static void main(String[] args) {
        System.out.println(-82 % 10);
    }
}
