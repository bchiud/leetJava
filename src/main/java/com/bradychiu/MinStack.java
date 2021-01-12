package com.bradychiu;

import java.util.Stack;

public class MinStack {
    public class MinStackTwoStack {
        private Stack<Integer> nums;
        private Stack<Integer> min;

        public MinStackTwoStack() {
            nums = new Stack<Integer>();
            min = new Stack<Integer>();
        }

        public void push(int x) {
            nums.push(x);
            if (min.isEmpty() || min.peek() >= x)
                min.push(x);
        }

        public void pop() {
            if (min.peek().equals(nums.peek()))
                min.pop();
            nums.pop();
        }

        public int top() {
            return nums.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }



    public class MinStackOneStack {
        private int min;
        private Stack<Integer> stack;

        public MinStackOneStack() {
            min = Integer.MAX_VALUE;
            stack = new Stack<>();
        }

        public void push(int x) {
            if (x <= min) {
                min = x;
                stack.push(x);
            }
            stack.push(x);

        }

        public void pop() {
            if (stack.pop() == min)
                min = stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
