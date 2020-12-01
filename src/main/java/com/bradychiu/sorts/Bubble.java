package com.bradychiu.sorts;

public class Bubble {

    /**
     * time: n^2
     * space: 1
     */
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean swapped = false;

            for(int j = 0; j < a.length - 1 - i; j++) {
                if(a[j + 1].compareTo(a[j]) < 0) {
                    swap(a, j, j + 1);
                    swapped = true;
                }
            }

            if(!swapped) {
                System.out.println("Loops: " + i);
                break;
            }
        }

    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
