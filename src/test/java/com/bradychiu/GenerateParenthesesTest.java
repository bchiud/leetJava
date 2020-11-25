package com.bradychiu;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesesTest {

    private static List<String> runSolution(int input) {
        // return GenerateParentheses.generateParenthesisBruteForce(input);
        // return GenerateParentheses.generateParenthesisBacktracking(input);
        return GenerateParentheses.generateParenthesisClosureNumber(input);
    }

    @Test
    void one() {
        int input = 1;
        List<String> expected = Arrays.asList("()");
        List<String> actual = runSolution(input);

        assert expected.size() == actual.size()
                && expected.containsAll(actual)
                && actual.containsAll(expected);
    }

    @Test
    void two() {
        int input = 2;
        List<String> expected = Arrays.asList("()()", "(())");
        List<String> actual = runSolution(input);

        assert expected.size() == actual.size()
                && expected.containsAll(actual)
                && actual.containsAll(expected);
    }

    @Test
    void three() {
        int input = 3;
        List<String> expected = Arrays.asList("((()))","(()())","(())()","()(())","()()()");
        List<String> actual = runSolution(input);

        assert expected.size() == actual.size()
                && expected.containsAll(actual)
                && actual.containsAll(expected);
    }

}