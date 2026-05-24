package com.florebencia.filsaime;

//for leetcode question: https://leetcode.com/problems/button-with-longest-push-time/description/
public class ButtonWithLongestTime {

    public int solution(int[][] events){
        // return the index with the longest time to push
        if (events.length == 1){
            return events[0][0];
        }

        int solution = events[0][0]; // will keep track of the index with the highest wait time
        int maxTime = events[0][1];
        int oldMaxTime = 0;
        for (int i = 1; i < events.length; i++){
            oldMaxTime = maxTime;
            if (events[i][1] - events[i - 1][1] > maxTime){
                solution = events[i][0];
                maxTime = events[i][1] - events[i - 1][1];
            } else if (events[i][1] - events[i - 1][1] == maxTime){
                solution = Math.min(events[i][0], solution);
            }
        }

        return solution;
    }
}
