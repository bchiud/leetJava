package com.bradychiu;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesesTest {

    @Test
    void one() {
        int input = 1;
        List<String> expected = Arrays.asList("()");
        List<String> actual = GenerateParentheses.generateParenthesis(input);

        assert expected.size() == actual.size()
                && expected.containsAll(actual)
                && actual.containsAll(expected);
    }

    @Test
    void two() {
        int input = 2;
        List<String> expected = Arrays.asList("()()", "(())");
        List<String> actual = GenerateParentheses.generateParenthesis(input);

        assert expected.size() == actual.size()
                && expected.containsAll(actual)
                && actual.containsAll(expected);
    }

    @Test
    void three() {
        int input = 3;
        List<String> expected = Arrays.asList("((()))","(()())","(())()","()(())","()()()");
        List<String> actual = GenerateParentheses.generateParenthesis(input);

        assert expected.size() == actual.size()
                && expected.containsAll(actual)
                && actual.containsAll(expected);
    }

}