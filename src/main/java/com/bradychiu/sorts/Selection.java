package com.bradychiu.sorts;

public class Selection {

    /**
     * time: n^2
     * space: 1
     */
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if ( a[j].compareTo(a[minIndex]) < 0)
                    minIndex = j;
            }
            if (i != minIndex)
                  swap(a, i, minIndex);
        }
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
