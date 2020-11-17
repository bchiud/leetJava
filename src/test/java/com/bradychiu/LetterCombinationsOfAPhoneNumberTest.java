package com.bradychiu;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LetterCombinationsOfAPhoneNumberTest {

    @Test
    void one() {
        String digits = "23";
        List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");

        List<String> actual = LetterCombinationsOfAPhoneNumber.letterCombinations(digits);

        assert (expected.size() == actual.size()
                && expected.containsAll(actual)
                && actual.containsAll(expected));
    }

}