package com.bradychiu;

import java.util.NoSuchElementException;

public class Vector2D {

    private int[][] v;
    private int i;
    private int j;

    /**
     * time: 1
     * space: 1
     */
    public Vector2D(int[][] v) {
        this.v = v;
        i = 0;
        j = 0;
    }

    /**
     * time: v / n
     * space:
     */
    public int next() {
        if (!hasNext())
            throw new NoSuchElementException();
        return v[i][j++];
    }

    /**
     * time: v / n
     * space: 1
     */
    public boolean hasNext() {
        while (i < v.length && j == v[i].length) {
            i++;
            j = 0;
        }
        return i < v.length;
    }

}
