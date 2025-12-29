package com.florebencia.filsaime;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * url of the question: https://leetcode.com/problems/number-of-recent-calls/description/?envType=problem-list-v2&envId=queue
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 * This is to be used in NumberOfRecentCalls Class for leetcode
 * */
public class RecentCounter {

    private int counter;
    private Deque<Integer> queue = new ArrayDeque<Integer>();

    public RecentCounter() {
        this.counter = 0;
    }

    public int ping(int t) {
        //todo need to make this faster

        // requests can't be negative
        // add pings to the the Queue
        // you will probably have to pop what ever numbers don't fit in the range
        int[] range = findRange(t);
        if (t >= range[0] && t <= range[1]){
            queue.add(t);
        }

        // check if all elements fit in that range
        Deque<Integer> temp = new ArrayDeque<>(queue);
        for (Integer i : queue){
            if (i < range[0] || i > range[1]){
                temp.pop();
            }
        }

        counter = temp.size();
        queue = temp;
        return counter;
    }

    public int[] findRange(int t){
        int[] solution = new int[2];
        solution[1] = t;
        solution[0] = t - 3000;
        return solution;
    }

    public void printQueue(){
        System.out.println("This is the queue: " + queue);
    }
}
