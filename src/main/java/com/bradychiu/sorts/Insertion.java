package com.bradychiu.sorts;

public class Insertion {

    /**
     * time: n^2
     * space: 1
     */
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            // System.out.println("i: " + i);
            for (int j = i; j > 0; j--) {
                // System.out.println("j: " + j);
                if (a[j - 1].compareTo(a[j]) > 0) {
                    swap(a, j - 1, j);
                }
                // printArray(nums);
            }
        }
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void printArray(Comparable a[]) {
        String s = "";
        for (Comparable i : a) {
            s += i + ", ";
        }
        System.out.println(s.substring(0, s.length() - 2));
    }
}
