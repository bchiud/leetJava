package com.bradychiu;

public class PowerOfThree {
    public static void printResults() {
        System.out.println("Power of Three ");

        System.out.println(new StringBuilder()
                .append("Recursive: ")
                .append(PowerOfThree.isPowerOfThreeRecursive(243)));
        System.out.println(new StringBuilder()
                .append("Logarithm: ")
                .append(PowerOfThree.isPowerOfThreeLogarithm(243)));
        System.out.println(new StringBuilder()
                .append("Optimal: ")
                .append(PowerOfThree.isPowerOfThreeOptimal(243)));
    }

    public static boolean isPowerOfThreeRecursive(int n) {
        // if ___ ? then ___ : else ___
        return n == 0 ? false : n == 1 || (n % 3 == 0 && isPowerOfThreeRecursive(n / 3));
    }

    public static boolean isPowerOfThreeLogarithm(int n) {
        // double % 1 returns numbers after decimal
        double d = 2.342;
        System.out.println(d % 1.5);
        System.out.println(d % 1);

        // return Math.log(n) / Math.log(3) % 1 == 0; // doesnt work due to rounding error
        return Math.log10(n) / Math.log10(3) % 1 == 0;
    }

    public static boolean isPowerOfThreeOptimal(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return n > 0 && (1162261467 % n == 0);
    }
}
