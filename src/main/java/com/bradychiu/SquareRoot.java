package com.bradychiu;

public class SquareRoot {

    public static void printResults() {
        System.out.println("Square Root");

        System.out.println(new StringBuilder()
                .append("Original: ")
                .append(SquareRoot.squareRootOriginal(99))
                .toString());
        System.out.println(new StringBuilder()
                .append("Original: ")
                .append(SquareRoot.squareRootOriginal(100))
                .toString());
        System.out.println(new StringBuilder()
                .append("Original: ")
                .append(SquareRoot.squareRootOriginal(101))
                .toString());
    }

    static double squareRootOriginal(int input) {

        if(input == 0) {
            return 0;
        }

        int left = 1, right = input / 2 + 1;

        while(left + 1 < right) {
            int mid = ( left + right ) / 2;

            if( mid * mid > input) { // 3 * 3 > 5
                right = mid - 1;
            } else if( (mid+1)*(mid+1) > input) {
                return mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }

}
