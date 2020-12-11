package com.bradychiu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class HappyNumber {

    /**
     * time: log(n)
     * space: log(n)
     */
    public static boolean isHappyHashSet(int n) {
        Set<Integer> memory = new HashSet<>();
        while (n != 1 && !memory.contains(n)) {
            memory.add(n);
            n  = genNext(n);
        }

        return n == 1;
    }

    /**
     * time: log(n)
     * space: 1
     */
    public static boolean isHappyFloyd(int n) {
        int slow = n;
        int fast = genNext(n); // need to apply genNext so while loop passes condition and starts

        while (fast != 1 && slow != fast) {
            slow = genNext(slow);
            fast = genNext(genNext(fast));
        }

        return fast == 1; // if n is a happy number, fast will turn into 1 first
    }

    private static int genNext(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
