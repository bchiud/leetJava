package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncreasingTripletTest {

    @Test
    void one() {
        int[] input = new int[]{1, 2, 3, 4, 5};
        boolean expected = true;
        assertEquals(expected, IncreasingTriplet.increasingTriplet(input));
    }

    @Test
    void two() {
        int[] input = new int[]{5, 4, 3, 2, 1};
        boolean expected = false;
        assertEquals(expected, IncreasingTriplet.increasingTriplet(input));
    }

    @Test
    void three() {
        int[] input = new int[] {2,1,5,0,4,6};
        boolean expected = true;
        assertEquals(expected, IncreasingTriplet.increasingTriplet(input));
    }

    @Test
    void four() {
        int[] input = new int[] {5,1,5,5,2,5,4};
        boolean expected = true;
        assertEquals(expected, IncreasingTriplet.increasingTriplet(input));
    }

    @Test
    void five() {
        int[] input = new int[] {1,1,1,1,1,1,1,1,1,1,1};
        boolean expected = false;
        assertEquals(expected, IncreasingTriplet.increasingTriplet(input));
    }

    @Test
    void six() {
        int[] input = new int[] {1,1,-2,6};
        boolean expected = false;
        assertEquals(expected, IncreasingTriplet.increasingTriplet(input));
    }

}