package com.bradychiu;

public class Sqrt {

    /**
     * time: log n
     * space: 1
     */
    public static int mySqrtBinary(int x) {

        if (x < 2)
            return x;

        int left = 2;
        int pivot;
        int right = x / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2 ;

            if (x / pivot == pivot)
                return pivot;
            else if (x / pivot > pivot)
                left = pivot + 1;
            else
                right = pivot - 1;
        }

        return right;

    }

}
