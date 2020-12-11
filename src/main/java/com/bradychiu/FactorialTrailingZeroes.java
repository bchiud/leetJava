package com.bradychiu;

import java.math.BigInteger;

public class FactorialTrailingZeroes {

    /**
     * time: >n^2
     * space: n log(n) ; in order to store n!, we need log(n!) => n log(n)
     */
    public static int trailingZeroesComputeFactorial(int n) {
        if (n == 0)
            return 0;

        BigInteger sum = BigInteger.ONE;
        while (n > 1) {
            System.out.println(n);
            sum = sum.multiply(BigInteger.valueOf(n--));
            System.out.println(sum);
        }
        System.out.println(sum);

        int zeroes = 0;
        while (sum.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            zeroes++;
            sum = sum.divide(BigInteger.TEN);
        }

        return zeroes;
    }

    /**
     * time: n
     * space: 1
     * <p>
     * since 2 * 5 = 10, count the number of pairs of 2*5 in the factorials
     * there will always be more 2's than 5's, so we only need to count the 5's
     */
    public static int trailingZeroesFactorsOfFive(int n) {
        int zeroes = 0;
        for (int i = 5; i <= n; i += 5) {
            int cur = i;
            while (cur % 5 == 0) {
                cur /= 5;
                zeroes++;
            }
        }

        return zeroes;
    }

    /**
     * time: log n
     * space: 1
     * <p>
     * same as above but faster
     */
    public static int trailingZeroesFactorsOfFiveFaster(int n) {
        int zeroes = 0;
        long currentMultipleOfFive = 5;
        while (n >= currentMultipleOfFive) {
            zeroes += (n / currentMultipleOfFive);
            currentMultipleOfFive *= 5;
        }
        return zeroes;
    }

    /**
     * time: log n
     * space: 1
     * <p>
     * same as above but cleaner
     */
    public static int trailingZeroesFactorsOfFiveCleaner(int n) {
        int zeroes = 0;
        while (n > 0) {
            n /= 5;
            zeroes += n;
        }
        return zeroes;
    }

    /**
     * time: log n
     * space: 1
     * <p>
     * same as above but even cleaner
     */
    public static int trailingZeroesFactorsOfFiveOneLiner(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroesFactorsOfFiveOneLiner(n / 5);
    }

}
