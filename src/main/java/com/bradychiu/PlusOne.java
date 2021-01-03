package com.bradychiu;

public class PlusOne {
    /**
     * time: n digits
     * space: n digits (if we need to copy array)
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                if (i == 0) {
                    digits = new int[digits.length + 1];
                    digits[0] = 1;
                    return digits;
                } else {
                    digits[i] = 0;
                }
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }

        return digits;
    }
}
