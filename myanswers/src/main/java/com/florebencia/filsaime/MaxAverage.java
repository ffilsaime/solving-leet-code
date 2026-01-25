package com.florebencia.filsaime;

//leet code problem: https://leetcode.com/problems/maximum-average-subarray-i/description/
public class MaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        // need largest average to be the first average we see
        double largestAverage = 0.0;
        boolean isFirstAverage = true;
        int kTracker = 0;
        // when you're traversing between windows, subtract the left most window
        if (nums.length == 1){
            return Double.valueOf(nums[0]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (kTracker < k - 1) {
                // sum some of the numbers first
                sum += nums[i];
                kTracker++;
            } else {
                sum += nums[i];
                double avg = sum / k;
                if (isFirstAverage){
                    largestAverage = avg;
                    isFirstAverage = false;
                }

                if (avg > largestAverage) {
                    largestAverage = avg;
                }
                // subtract the left-most number
                sum -= nums[i - (k - 1)];
            }
        }

        return largestAverage;
    }
}
