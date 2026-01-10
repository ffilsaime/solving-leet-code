package com.florebencia.filsaime.implement;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a number N return the index value of the Fibonacci sequence, where the sequence is:
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
 * the pattern of the sequence is that each value is the sum of the 2 previous values, that means that
 * for n = 5, 2 + 3
 */
public class Fibonacci {

    private List<Integer> cache = new ArrayList<>();

    public Fibonacci() {
        cache.add(0);
        cache.add(1);
        cache.add(1);
    }

    public int getValueIterative(int n){
        //NOTE: return the nth term of the sequence
        // I am assuming there is no Oth term
        int[] startingArray = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
        int prevInt = 1;
        int prevPrevInt = 1;
        int solution = 0;
        if (n == 1) return 0;

        if (n == 2) return 1;

        if (n == 3) return 1;

        for (int i = 4; i <= n; i++){
            solution = prevInt + prevPrevInt;
            prevPrevInt = prevInt;
            prevInt = solution;
        }

        return solution;
    }

    public int getValueRecursive(int n){
        //NOTE: return the nth term of the sequence
        // I am assuming there is no Oth term
        // write base case(s)
        if (n == 1) {
            return 0;
        } else if(n == 2) {
            return 1;
        } else if (n == 3) {
            return 1;
        }

        // write recursive case
        return getValueRecursive(n-1) + getValueRecursive(n-2);
    }

    // this method is going to be done with dynamic programming in mind
    //I'm going to assume there's a 0th term
    // I used a solution like this for leet code's version of this problem
    public int getValue(int n){
        if (cache.size() > n){
            return cache.get(n);
        } else {
            int newValue = getValue(n - 1) + getValue(n - 2);
            cache.add(newValue);
            return newValue;
        }
    }
}
