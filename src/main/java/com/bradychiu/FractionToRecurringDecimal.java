package com.bradychiu;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

    public static String factionToDecimal(int numerator, int denominator) {
        boolean isNegative = (numerator < 0 & denominator > 0) || (numerator > 0 & denominator < 0);

        if (numerator == 0)
            return "0";

        if (denominator == 0)
            throw new ArithmeticException("Denominator cannot be 0");

        StringBuilder ans = new StringBuilder();
        if (numerator < 0 ^ denominator < 0)
            ans.append("-");

        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        ans.append((String.valueOf(dividend / divisor)));

        long remainder = dividend % divisor;
        if (remainder == 0)
            return ans.toString();

        ans.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                ans.insert(map.get(remainder), "(");
                ans.append(")");
                break;
            }
            map.put(remainder, ans.length());
            remainder *= 10;
            ans.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }

        return ans.toString();
    }
}
