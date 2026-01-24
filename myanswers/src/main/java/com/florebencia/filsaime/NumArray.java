package com.florebencia.filsaime;

//leet code question is here: https://leetcode.com/problems/range-sum-query-immutable/description/
public class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int size = (right - left) + 1;
        int[] arraySum = new int[size];
        arraySum[0] = nums[left];
        int index = 1;
        // just add each index as you go along
        for (int i = left + 1; i <= right; i++){
            arraySum[index] = arraySum[index-1] + nums[i];
            index++;
        }

        return arraySum[size - 1];
    }

    public int sumRangeV2(int left, int right) {
        //todo how do I make it faster?
        return 0;
    }
}
