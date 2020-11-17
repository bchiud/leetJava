package com.bradychiu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return result;

        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        result.add("");
        for (char c : digits.toCharArray())
            result = combiner(result, letters[c - '0']);

        return result;
    }

    private static List<String> combiner(List<String> original, String newLetters) {
        List<String> result = new ArrayList<>();

        for (String o : original)
            for (char c : newLetters.toCharArray())
                result.add(o + String.valueOf(c));

        return result;
    }
}
