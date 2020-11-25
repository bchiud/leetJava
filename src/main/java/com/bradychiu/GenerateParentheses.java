package com.bradychiu;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /**
     * algo: find all 2n character combos of '(' and ')' then evaluate if combo is valid
     *
     * time: n * 2 ^ 2n
     * space: n * 2 ^ 2n
     */
    public static List<String> generateParenthesisBruteForce(int n) {
        List<String> result = new ArrayList<>();

        if (n == 0) {
            result.add("");
            return result;
        }

        generate(result, new char[2 * n], 0);

        return result;
    }

    private static void generate(List<String> result, char[] current, int pos) {
        System.out.println(pos + " : " + new String(current));
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generate(result, current, pos + 1);

            current[pos] = ')';
            generate(result, current, pos + 1);
        }
    }

    private static boolean valid(char[] current) {
        int balance = 0;

        for (char c : current) {
            if (c == '(')
                balance++;
            if (c == ')')
                balance--;
            if (balance < 0)
                return false;
        }

        return balance == 0;
    }


    /**
     * algo:
     * 1) must place '(' or ')'
     * 2) close <= open
     * 3) n*2 characters
     *
     * time & space: wtf?
     *
     * time: (4^n) / (n ^ (1/2))
     * don't understand why ... some thoughts though:
     * 2^(2n - 1) nodes. intuitively tree height is 2n. combine with 2 forks at each node, we have 2 ^ 2n
     * nodes by level:
     * -- 0: 1 == 2^0
     * -- 1: 2 == 2^1
     * -- 2: 3 == 2^2
     * -- 3: 4 == 2^3
     * -- 4: 5 == 2^4
     * -- 5: 6 == 2^5
     *
     * space: (4^n) / (n ^ (1/2))
     * don't understand why ... some thoughts though:
     * nodes by level * s.length by level:
     * s.length by level:
     * -- 0: 1 == ?
     * -- 1: 2 == ?
     * -- 2: 3 == ?
     * -- 3: 4 == ?
     * -- 4: 5 == ?
     * -- 5: 6 == ?
     * each leaf node has s.length() == 2n
     */
    public static List<String> generateParenthesisBacktracking(int n) {
        List<String> result = new ArrayList<>();

        if (n == 0)
            return result;

        backtrack(result, "", 0, 0, n);

        return result;
    }

    private static void backtrack(List<String> result, String s, int open, int close, int max) {
        if (s.length() == max * 2)
            result.add(s);

        if (open < max)
            backtrack(result, s + "(", open + 1, close, max);
        if (close < open)
            backtrack(result, s + ")", open, close + 1, max);
    }

    /**
     * time: n * 2 ^ 2n
     * space: n * 2 ^ 2n
     */
    public static List<String> generateParenthesisClosureNumber(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesisClosureNumber(c))
                    for (String right: generateParenthesisClosureNumber(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }



}
