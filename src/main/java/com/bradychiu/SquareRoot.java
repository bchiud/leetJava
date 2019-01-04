package com.bradychiu;

public class SquareRoot {

//    public static void printResults() {
//        System.out.println(new StringBuilder()
//                .append("Square Root Original: ")
//                .append(SquareRoot.squareRootOriginal(4))
//                .toString());
//    }
//
//
//    static double squareRootOriginal(double input) {
//
//
//        /*
//        1) find if between exponent and exponent + 1
//        2) get mid point and determine if between midpoint
//        3) iterate per decimal place
//         */
//
//
//        if(input == 0 || input == 1) {
//            return input;
//        }
//
//        int base = 10;
//        int exponent = 1;
//
//        int upperBound = (int) Math.pow(base, exponent + 1);
//
//        while(input > Math.pow(upperBound, 2)) {
//            exponent += 1;
//            upperBound = (int) Math.pow(base, exponent);
//        }
//
//        int lowerBound = (int) Math.pow(base, exponent - 1);
//
//
//
//
//
//
//        int decimalPoints = 0;
//
//
//        while(true) {
//
//            int midPoint = ( lowerBound + upperBound ) / 2;
//            int midPointPow = (int) Math.pow(midPoint, 2);
//
//            if(lowerBound == upperBound - 1) {
//                break;
//            } else if (input == midPointPow) {
//                break;
//            } else if(input < midPointPow) {
//                upperBound = midPoint;
//            } else if(input > midPointPow) {
//                lowerBound = midPoint;
//            }
//
//
//        }
//
//
//
//
//
//
//
//
//        if(input > Math.pow(lowerBound, 2) & input < Math.pow(midPoint, 2)) {
//
//        }
//
//
//        double output = input;
//
//        return output;
//    }



}
