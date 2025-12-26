package com.florebencia.filsaime;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        // there's something wrong with this
        int prevValue = nums[0];
        int lastIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prevValue) {
                prevValue = nums[i];
                nums[lastIndex] = nums[i];
                lastIndex += 1;
            }
        }

        // this is the clean up for loop
        for (int i = nums.length - 1; i >= lastIndex; i--) {
            nums[i] = 0;
        }

        return lastIndex;
    }
}
