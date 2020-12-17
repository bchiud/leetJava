package com.bradychiu;

public class DivideTwoIntegers {

    /**
     * time: n
     * space: 1
     */

    public static int divideSubtraction(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        int quotient = 0;
        while (dividend - divisor <= 0) {
            quotient--;
            dividend -= divisor;
        }

        if (negatives != 1)
            quotient = -quotient;

        return quotient;
    }

    /**
     * time: (log n) ^ 2
     * spaec: 1
     */
    private static final int HALF_INT_MIN = -1073741824;

    public static int divideExponentialSearch(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        int quotient = 0;
        while (divisor >= dividend) {
            int twoToThePowerOf = -1;
            int value = divisor;
            while (HALF_INT_MIN <= value && dividend <= value + value) {
                value += value;
                twoToThePowerOf += twoToThePowerOf;
            }
            quotient += twoToThePowerOf;
            dividend -= value;
        }

        if (negatives != 1)
            quotient = -quotient;

        return quotient;
    }
}
