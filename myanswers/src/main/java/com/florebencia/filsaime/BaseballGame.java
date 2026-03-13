package com.florebencia.filsaime;

import java.util.Stack;

//leetcode problem: https://leetcode.com/problems/baseball-game/description/
public class BaseballGame {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < operations.length; i++){
            String op = operations[i];
            if(op.equals("C")){
                stack.pop();
            } else if (op.equals("D")){
                int oldRecord = stack.peek();
                stack.push(oldRecord * 2);
            } else if (op.equals("+")){
                int topRecord = stack.pop();
                int prevRecord = stack.pop();
                int newRecord = topRecord + prevRecord;
                stack.push(prevRecord);
                stack.push(topRecord);
                stack.push(newRecord);
            } else {
                int record = Integer.valueOf(op);
                stack.push(record);
            }
        }

        int total = 0;
        while (!stack.empty()){
            total += stack.pop();
        }

        return total;
    }
}
