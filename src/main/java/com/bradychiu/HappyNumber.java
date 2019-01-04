package com.bradychiu;

import java.util.ArrayList;
import java.util.HashSet;

class HappyNumber {
    public static void printResults() {
        System.out.println(new StringBuilder()
                .append("Happy Number Original: ")
                .append(HappyNumber.isHappyOriginal(9434)));
        System.out.println(new StringBuilder()
                .append("Happy Number Cleaner: ")
                .append(HappyNumber.isHappyCleaner(9434)));
        System.out.println(new StringBuilder()
                .append("Happy Number Optimal: ")
                .append(HappyNumber.isHappyOptimal(9434)));
    }
    static boolean isHappyOriginal(int n) {
        int currentInt = n;

        HashSet<Integer> previousNumbers = new HashSet<>();

        while(!previousNumbers.contains(currentInt)) {
            // System.out.println("Starting: " + currentInt);

            previousNumbers.add(currentInt);

            ArrayList<Integer> digits = new ArrayList<>();
            int temp = currentInt;
            while(temp != 0) {
                digits.add(0, temp % 10);
                temp /= 10;
            }
            // System.out.println("array " + digits.toString());

            currentInt = 0;
            for(int i : digits) {
                // System.out.println("adding: " + Math.pow(i, 2));
                currentInt += Math.pow(i, 2);
            }
            // System.out.println("Ending: " + currentInt);
            //
            // System.out.println("evaluation: " + (int) Math.log10(currentInt));
            // System.out.println("evaluation: " + Math.pow(10, (int) Math.log10(currentInt)));
            if(currentInt == Math.pow(10, (int) Math.log10(currentInt))) return true;
        }

        return false;
    }

    static boolean isHappyCleaner(int n) {
        HashSet<Integer> previousNumbers = new HashSet<>();

        int sumSquares, remain;
        while(previousNumbers.add(n)) {
            sumSquares = 0;
            while(n > 0) {
                remain = n % 10;
                sumSquares += remain*remain;
                n /= 10;
            }
            if(sumSquares == 1) return true;
            n = sumSquares;
        }
        return false;
    }

    static boolean isHappyOptimal(int n) {
        int x = n;
        int y = n;
        while(x > 1) {
            System.out.println("Start x: " + x);
            x = cal(x) ;
            System.out.println("End x: " + x);
            if(x == 1) return true;
            System.out.println("Start y: " + y);
            y = cal(cal(y));
            System.out.println("End y: " + y);
            if(y == 1) return true;
            if(x == y) return false;
        }
            return true ;
    }

    static int cal(int n){
        int x = n;
        int s = 0;
        while(x > 0){
            s = s + (x % 10) * (x % 10);
            x /= 10;
        }
        return s ;
    }
}
