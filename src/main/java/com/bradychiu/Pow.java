package com.bradychiu;

import java.math.BigDecimal;

public class Pow {

    /**
     * time: n
     * space: 1
     */
    public static double myPowBrute(double x, int n) {
        if (n == 0)
            return 1;

        long N = n;
        if (n < 0) {
            x = 1 / x;
            N *= -1;
        }

        double ans = 1;
        while (N > 0) {
            ans *= x;
            N--;
        }
        return ans;
    }

    /**
     * time: log n
     * space: log n
     */
    public static double myPowRecursive(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N *= -1;
        }
        return recursive(x, N);
    }

    private static double recursive(double x, long n) {
        if (n == 0)
            return 1.0;

        double half = recursive(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }

    /**
     * time: log n
     * space: log n
     */
    public static double myPowRecursiveCleaner(double x, int n) {
        if (n == 0)
            return 1.0;
        if (n < 0) {
            return 1 / x * myPowRecursive(1 / x, -(n + 1));
        }
        return ((n % 2 == 0) ? 1 : x) * (myPowRecursive(x * x, n / 2));
    }


    /**
     * time: log n
     * space: 1
     */
    public static double myPowIterative(double x, int n) {
        if (n == 0)
            return 1.0;

        double ans = 1;
        if (n < 0) {
            ans = 1 / x;
            x = 1 / x;
            n = -(n + 1);
        }

        while (n > 0) {
            if (n % 2 == 1)
                ans = ans * x;
            x = x * x;
            n = n / 2;
        }
        return ans;
    }
}
