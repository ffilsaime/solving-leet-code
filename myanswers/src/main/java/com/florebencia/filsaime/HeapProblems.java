package com.florebencia.filsaime;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapProblems {

    //for leetcode problem: https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/description/
    public int largestInteger(int num) {
        PriorityQueue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());
        // Have two max heaps one for even numbers and one for odd
        // pop from both heap whenever there's an odd or even number respectively
        // add that value to the string builder
        int solution = 0;
        String numStr = String.valueOf(num);
        for (int i = 0; i < numStr.length(); i++){
            int value = numStr.charAt(i) - '0';
            setUpTwoHeaps(even, odd, value);
        }

        for (int i = 0; i < numStr.length(); i++){
            solution *= 10;
            int value = numStr.charAt(i) - '0';
            if (value % 2 == 0){
                int popped = even.poll();
                solution += popped;
            } else {
                int popped = odd.poll();
                solution += popped;
            }
        }

        return solution;
    }

    private void setUpTwoHeaps(PriorityQueue<Integer> even, PriorityQueue<Integer> odd, int value){
        if (value % 2 == 0){
            even.add(value);
        } else {
            odd.add(value);
        }
    }
    //end of leetcode problem
}
