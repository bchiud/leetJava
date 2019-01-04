package com.bradychiu;

import java.util.ArrayList;

class RomanToInteger {
    public static void printResults() {
        System.out.println(new StringBuilder()
                .append("Roman To Ingeter Original: ")
                .append(RomanToInteger.romanToIntOriginal("MMMCMXCIV"))
                .toString());
        System.out.println(new StringBuilder()
                .append("Roman To Ingeter Math: ")
                .append(RomanToInteger.romanToIntMath("MMMCMXCIV"))
                .toString());
        System.out.println(new StringBuilder()
                .append("Roman To Ingeter Optimal: ")
                .append(RomanToInteger.romanToIntOptimal("MMMCMXCIV"))
                .toString());
    }
    static int romanToIntOriginal(String s) { // 99 ms
        int sLen = s.length();

        ArrayList<Integer> numbers = new ArrayList<>(); // array would have sufficed here b/c we know size already

        for(int i = 0; i < sLen; i++) {
            switch(s.charAt(i)) {
                case 'I':
                    numbers.add(1);
                    break;
                case 'V':
                    numbers.add(5);
                    break;
                case 'X':
                    numbers.add(10);
                    break;
                case 'L':
                    numbers.add(50);
                    break;
                case 'C':
                    numbers.add(100);
                    break;
                case 'D':
                    numbers.add(500);
                    break;
                case 'M':
                    numbers.add(1000);
                    break;
                default:
                    break;
            }
        }

        int finalNumber = 0;

        for(int j = 0; j < numbers.size(); j++) {
            if(j < numbers.size() - 1  && numbers.get(j) < numbers.get(j+1)){
                finalNumber += numbers.get(j+1) - numbers.get(j);
                j++;
            } else {
                finalNumber += numbers.get(j);
            }
        }

        return finalNumber;
    }

    static int romanToIntMath(String s) {
        int sum = 0;

        if(s.contains("IV")) sum -= 2;
        if(s.contains("IX")) sum -= 2;
        if(s.contains("XL")) sum -= 20;
        if(s.contains("XC")) sum -= 20;
        if(s.contains("CD")) sum -= 200;
        if(s.contains("CM")) sum -= 200;

        char c[] = s.toCharArray();

        for(int count = 0; count <= s.length()-1; count++){
            switch(c[count]) {
                case 'M':
                    sum += 1000;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'C':
                    sum += 100;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'X':
                    sum += 10;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'I':
                    sum += 1;
                    break;
            }
        }

        return sum;
    }

    static int romanToIntOptimal(String s) { // 94 ms
        int[] numbers = new int[s.length()];

        for(int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'I':
                    numbers[i] = 1;
                    break;
                case 'V':
                    numbers[i] = 5;
                    break;
                case 'X':
                    numbers[i] = 10;
                    break;
                case 'L':
                    numbers[i] = 50;
                    break;
                case 'C':
                    numbers[i] = 100;
                    break;
                case 'D':
                    numbers[i] = 500;
                    break;
                case 'M':
                    numbers[i] = 1000;
                    break;
                default:
                    break;
            }
        }

        int sum = 0;
        for(int j = 0; j < numbers.length - 1; j++) {
            sum = numbers[j] < numbers[j + 1] ? sum - numbers[j] : sum + numbers[j];
            // if(numbers[j] < numbers[j + 1]) {
            //     sum -= numbers[j];
            // } else {
            //     sum += numbers[j];
            // }
        }

        return sum + numbers[numbers.length - 1];
    }
}
