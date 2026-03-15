package com.florebencia.filsaime;

//for leetcode problem: https://leetcode.com/problems/binary-search/description/
public class BinarySearch {

    public int search(int[] nums, int target) {
        if(nums.length == 1){
            if(target == nums[0]) return 0;
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int middle = nums.length / 2;
        while(left != right){
            if(nums[left] == target){
                return left;
            } else if (nums[right] == target){
                return right;
            } else if(target == nums[middle]){
                return middle;
            } else if (target < nums[middle]){
                //change right to middle
                right = middle - 1;
                middle = (right - left)/2 + left;
            } else {
                // change left to middle since target > nums[middle]
                left = middle + 1;
                middle = (right - left)/2 + left;
            }
        }
        return -1;
    }
}
