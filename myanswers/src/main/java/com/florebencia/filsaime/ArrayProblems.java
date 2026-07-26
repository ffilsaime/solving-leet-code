package com.florebencia.filsaime;

import java.util.Arrays;

public class ArrayProblems {

    //for leetcode problem: https://leetcode.com/problems/rotate-array/description/
    public void rotate(int[] nums, int k) {
        if (nums.length == 1){
            return;
        }

        //todo what if you rotate the list more times than it's size?
        //how about find the modulo of k and use that as a basis
        int newK = (k > nums.length) ? k % nums.length : k;
        System.out.println("This is the value of newK: " + newK);

        int[] endingIndices = new int[newK];
        int index = nums.length - newK;
        int j = 0;

        //getting the last k elements so I can put them in the front later
        for(int i = index; i < nums.length; i++){
            endingIndices[j] = nums[i];
            j++;
        }

        System.out.println("endingIndices looks like this: " +  Arrays.toString(endingIndices));

        // shifting the rest of the numbers to the right
        for (int i = index - 1; i >= 0; i--){
            nums[i + newK] = nums[i];
        }

        System.out.println("endingIndices looks like this: " +  Arrays.toString(nums));

        for (int i = 0; i < newK; i++){
            nums[i] = endingIndices[i];
        }
    }
}
