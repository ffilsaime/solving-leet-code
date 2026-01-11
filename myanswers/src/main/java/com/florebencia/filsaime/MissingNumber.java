package com.florebencia.filsaime;

import java.util.HashMap;

// for the leet code problem: https://leetcode.com/problems/missing-number/description/
public class MissingNumber {

    HashMap<Integer, String> map = new HashMap<>();

    public int doProblem(int[] nums) {
        for (Integer number : nums) {
            map.put(number, "");
        }

        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(i)){
                return i;
            }
        }

        return nums.length;
    }
}
