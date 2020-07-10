package com.bradychiu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    private static int[] inputOne;
    private static ArrayList<List<Integer>> outputOne;

    @BeforeAll
    static void init() {
        inputOne = new int[]{-1, 0, 1, 2, -1, -4};
        outputOne = new ArrayList<>();
        outputOne.add(Arrays.asList(-1, 0 , 1));
        outputOne.add(Arrays.asList(-1, 2 , -1));
        outputOne.add(Arrays.asList(0, 1 , -1));
    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void threeSumBrute() {
        assert(outputOne.containsAll(ThreeSum.threeSumBrute(inputOne)));
    }

    @Test
    void threeSumQuadratic() {
    }
}