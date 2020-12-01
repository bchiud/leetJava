package com.bradychiu.sorts;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quick {

    /**
     * time: n log(n) usually, n^2 in worst case
     * space: 1
     */

    public static void sort(Comparable[] a) {
        System.out.print("Original: "); printArray(a);

        // using Collections:
        // List<Comparable> comparableList = Arrays.asList(a);
        // Collections.shuffle(comparableList);
        // comparableList.toArray(a);

        // using Random
        shuffle(a);

        System.out.print("Shuffled: "); printArray(a);

        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int partitionIndex = partition(a, lo, hi);
        sort(a, lo, partitionIndex - 1);
        sort(a, partitionIndex + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        System.out.println("lo: " + lo + "; hi: " + hi);
        int i = lo;
        int j = hi + 1;

        Comparable partitionVal = a[lo];
        while (true) {
            while (a[++i].compareTo(partitionVal) < 0) {
                if (i >= hi)
                    break;
            }

            while (a[--j].compareTo(partitionVal) > 0) {
                if (j <= lo)
                    break;
            }

            if(i >= j)
                break;

            System.out.print("preSwap: "); printArray(a);
            System.out.println("partitionVal: " + partitionVal + "; i: " + i + "; j: " + j + "; ");
            swap(a, i, j);
            System.out.print("postSwap: "); printArray(a);
        }

        System.out.print("preSwap: "); printArray(a);
        swap(a, lo, j);
        System.out.print("postSwap: "); printArray(a);

        return j;
    }

    private static void shuffle(Comparable[] a) {
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = random.nextInt(a.length);
            swap(a, i, r);
        }
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void printArray(Comparable[] a) {
        String s = "";
        for (Comparable c : a) {
            s += c + ", ";
        }
        System.out.println(s.substring(0, s.length() - 2));
    }

}
