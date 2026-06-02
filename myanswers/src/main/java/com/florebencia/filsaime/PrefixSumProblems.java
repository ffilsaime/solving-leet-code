package com.florebencia.filsaime;

public class PrefixSumProblems {
    //for leetcode problem: https://leetcode.com/problems/subarray-sum-equals-k/description/
    public int subarraySum(int[] nums, int k) {
        // this is really slow; I should do this again to make it faster
        if (nums.length == 1 && nums[0] == k){
            return 1;
        }

        int length = nums.length;
        int[] prefix = new int[length + 1];
        int counter = 0;

        for (int i = 1; i <= length; i++){
            // just to set up the prefix sum nums
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (prefix[end] - prefix[start] == k)
                    counter++;
            }
        }

        return counter;
    }


}
