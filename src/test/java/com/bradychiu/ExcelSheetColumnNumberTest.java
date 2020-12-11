package com.bradychiu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExcelSheetColumnNumberTest {

    private static int runSolution(String s) {
        // return ExcelSheetColumnNumber.titleToNumberFull(s);
        // return ExcelSheetColumnNumber.titleToNumber(s);
        // return ExcelSheetColumnNumber.titleToNumberOneLiner(s);
        return ExcelSheetColumnNumber.titleToNumberJava8(s);
    }

    @Test
    void one() {
        assertEquals(1, runSolution("A"));
    }

    @Test
    void two() {
        assertEquals(28, runSolution("AB"));
    }

    @Test
    void three() {
        assertEquals(701, runSolution("ZY"));
    }

    @Test
    void four() {
        assertEquals(703, runSolution("AAA"));
    }

}