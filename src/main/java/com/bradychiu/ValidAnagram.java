package com.bradychiu;

import java.util.Arrays;

public class ValidAnagram {
    /**
     * time: n log n for sorting
     * space: n
     */
    public static boolean isAnagramSort(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        mergeSort(sArray);
        mergeSort(tArray);
        // Arrays.sort(sArray);
        // Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }

    private static void mergeSort(char[] c) {
        char[] aux = new char[c.length];

        mergeSort(c, aux, 0, c.length - 1);
    }

    private static void mergeSort(char[] c, char[] aux, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(c, aux, lo, mid);
        mergeSort(c, aux, mid + 1, hi);
        merge(c, aux, lo, mid, hi);
    }

    private static void merge(char[] c, char[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++)
            aux[i] = c[i];

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                c[k] = aux[j++];
            else if (j > hi)
                c[k] = aux[i++];
            else if (aux[j] < aux[i])
                c[k] = aux[j++];
            else
                c[k] = aux[i++];
        }
    }

    /**
     * time: n
     * space: 1
     */
    public static boolean isAnagramHashTableArray(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        for (char c : t.toCharArray())
            count[c - 'a']--;

        for (int n : count)
            if (n != 0)
                return false;

        return true;
    }
}
