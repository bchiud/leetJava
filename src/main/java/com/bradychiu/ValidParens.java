package com.bradychiu;

import java.util.Stack;

public class ValidParens {
    public static void printResults() {
        System.out.println(new StringBuilder()
                .append("Valid Parenthesis Orignal: ")
                .append(ValidParens.isValidOriginal("([])]")));
        System.out.println(new StringBuilder()
                .append("Valid Parenthesis Math: ")
                .append(ValidParens.isValidMath("([{}])()[][][][]")));
        // System.out.println(new StringBuilder()
        //         .append("Valid Parenthesis Optimal")
        //         .append(ValidParens.isValidOptimal("()[]{}()[][][][]")));
    }

    public static boolean isValidOriginal(String s) {
        String closers = "";
        for(char c : s.toCharArray()) {
            int closersLen = closers.length();
            // System.out.println("current char: " + String.valueOf(c));
            if(c == '(') closers += String.valueOf(')');
            else if(c == '{') closers += String.valueOf('}');
            else if(c == '[') closers += String.valueOf(']');
            // remove last closer if matches
            else if(closersLen > 0 && c == closers.charAt(closersLen - 1)) closers = closers.substring(0, closersLen - 1);
            // last character doesn't match or extra closer
            else return false;
            // System.out.println("closers: " + closers);
        }

        // not fully closed
        if(closers.length() != 0) return false;

        return true;
    }

    public static boolean isValidMath(String s) {
        Stack<Integer> p = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            int q = "(){}[]".indexOf(s.substring(i, i + 1));
            //if closer
            if(q % 2 == 1) {
                // if closer doesnt match;
                if(p.isEmpty() || p.pop() != q - 1) return false;
            } else p.push(q); // add opener
        }
        return p.isEmpty();
    }

    public static boolean isValidOptimal(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
            System.out.println(stack);
        }
        return stack.isEmpty();
    }
}