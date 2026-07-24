package com.florebencia.filsaime;

import java.util.Stack;

public class StackProblems {

    //for leetcode problem: https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++){
            String current = tokens[i];
            if (isANumber(current)){
                //everytime there's a number you add it to the stack
                stack.push(current);
            } else {
                // everytime there's an operator, pop the last two numbers process them with the operator
                // push the value back to the stack
                int operand = Integer.parseInt(stack.pop());
                int operand2 = Integer.parseInt(stack.pop());
                String newVal = processOperator(current, operand2, operand);
                stack.push(newVal);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private boolean isANumber(String potentialNum){
        try {
            Integer.parseInt(potentialNum);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    private String processOperator(String op, int num, int num2){
        int newVal;
        switch (op) {
            case "+":
                newVal = num + num2;
                break;
            case "-":
                newVal = num - num2;
                break;
            case "*":
                newVal = num * num2;
                break;
            case "/":
                newVal = num / num2;
                break;
            default:
                // it shouldn't hit the default case
                newVal = 1;
        }

        return String.valueOf(newVal);
    }
    // end of leetcode problem
}
