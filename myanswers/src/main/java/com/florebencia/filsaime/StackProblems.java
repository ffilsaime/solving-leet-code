package com.florebencia.filsaime;

import java.util.Arrays;
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

    //for leetcode problem: https://leetcode.com/problems/simplify-path/description/
    public String simplifyPath(String path) {
        if (path.length() == 1){
            return path;
        }

        Stack<String> stack = new Stack<>();
        String[] pathSplit = path.split("/");

        System.out.println("This is what pathSplit looks like: " + Arrays.toString(pathSplit));
        for (String part: pathSplit){
            if (part.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
                //do nothing if the stack is empty
            } else if (!part.isEmpty() && !part.equals(".")){
                stack.push("/" + part);
            } else {
                System.out.println("This was probably an extra slash: " + part);
            }
        }

        if (stack.isEmpty()){
            return "/";
        }

        String answer = "";
        while (!stack.isEmpty()){
            answer = stack.pop() + answer;
            System.out.println("This is what answer looks like: " + answer);
        }

        return answer;
    }

    //for leetcode problem: https://leetcode.com/problems/removing-stars-from-a-string/description/
    // I used a StringBuilder like a stack
    //todo need to make this more efficient
    public String removeStars(String s) {
        if (s.length() == 1){
            if (s.equals("*")) return "";
            return s;
        }
        //treat a stringbuilder like a stack
        StringBuilder stack = new StringBuilder("");
        for (int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            if (letter == '*'){
                int length = stack.length();
                stack.deleteCharAt(length - 1);
            } else {
                stack.append(letter);
            }
        }
        return stack.toString();
    }
}
