package com.florebencia.filsaime;

import java.util.Arrays;

//for leetcode problem: https://leetcode.com/problems/meeting-rooms/description/
public class CanAttendMeetings {

    public boolean canAttendMeetings(int[][] intervals) {
        // need to sort the first interval and check if the next startInterval is in that range
        if (intervals.length == 0){
            return true;
        }

        //interval array has at least one row
        if (intervals.length == 1){
            return true;
        }

        //time to sort the intervals
        int[][] sortedIntervals = sort(intervals);

        for (int i = 0; i < sortedIntervals.length - 1; i++){
            int[] current = sortedIntervals[i];
            int[] next = sortedIntervals[i + 1];
            if (next[0] < current[1]){
                return false;
            }
        }

        return true;
    }

    private int[][] sort(int[][] intervals){
        if (intervals == null || intervals.length <= 1){
            return intervals;
        }

        int[][] left = Arrays.copyOfRange(intervals, 0, intervals.length/2);
        int[][] right = Arrays.copyOfRange(intervals, intervals.length/2, intervals.length);

        return merge(sort(left), sort(right));
    }

    public int[][] merge(int[][] left, int[][] right){
        int newLength = left.length+right.length;
        int[][] result = new int[newLength][2];

        int index = 0;
        int rightIndex = 0;
        int leftIndex = 0;

        while ((rightIndex != right.length) && (leftIndex != left.length)) {
            if (left[leftIndex][0] < right[rightIndex][0]) {
                result[index] = left[leftIndex];
                leftIndex++;
            } else {
                result[index] = right[rightIndex];
                rightIndex++;
            }
            index++;
        }

        // last two if statements checks for leftover elements missed
        if (leftIndex < left.length) {
            for (int i = leftIndex; i < left.length; i++) {
                result[index] = left[i];
                index++;
            }
        }
        if (rightIndex < right.length) {
            for (int i = rightIndex; i < right.length; i++) {
                result[index] = right[i];
                index++;
            }
        }
        return result;
    }
}
