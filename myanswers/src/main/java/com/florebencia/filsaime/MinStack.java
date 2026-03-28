package com.florebencia.filsaime;

import java.util.Stack;

//leetcode problem: https://leetcode.com/problems/min-stack/
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minTracker;

    public MinStack() {
        stack = new Stack<>();
        minTracker = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minTracker.isEmpty()){
            minTracker.push(val);
        } else {
            int prevInt = minTracker.peek();
            minTracker.push(Math.min(prevInt, val));
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
        }

        if(!minTracker.isEmpty()){
            minTracker.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minTracker.peek();
    }
}
