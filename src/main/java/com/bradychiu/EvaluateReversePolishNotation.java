package com.bradychiu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    /**
     * time: n
     * space: n
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> ops = new HashSet<>(Arrays.asList("+","-","*","/"));
        for (String cur : tokens) {
            if (!ops.contains(cur)) {
                stack.push(Integer.valueOf(cur));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch(cur) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
