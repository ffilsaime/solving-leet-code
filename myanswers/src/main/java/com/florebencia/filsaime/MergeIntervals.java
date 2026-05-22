package com.florebencia.filsaime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//for leetcode problem: https://leetcode.com/problems/merge-intervals/description/
public class MergeIntervals {

    class ArrayComparator implements Comparator<int[]> {
        public int compare(int[] arr1, int[] arr2){
            return arr1[0] - arr2[0];
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1){
            return intervals;
        }

        List<int[]> list = new ArrayList<>(); //holds the arrays for now
        //sort the arrays and then check if the start interval is less than the previous end interval
        Arrays.sort(intervals, new ArrayComparator());
        int[] lastArr = new int[2];
        lastArr[0] = intervals[0][0];
        lastArr[1] = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            if (lastArr[1] >= intervals[i][0]){
                // you would keep the start interval of lastArr but take the end interval of current value
                if (lastArr[1] < intervals[i][1]) {
                    lastArr[1] = intervals[i][1];
                }
            } else {
                // add lastArr to list and set lastArr to the currentInterval
                list.add(lastArr);
                lastArr = new int[2];
                lastArr[0] = intervals[i][0];
                lastArr[1] = intervals[i][1];
            }

            if (i == intervals.length - 1){
                list.add(lastArr);
            }
        }
        return list.toArray(new int[0][]);
    }
}
