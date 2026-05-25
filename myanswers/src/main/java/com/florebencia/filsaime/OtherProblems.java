package com.florebencia.filsaime;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is for the leet code problems that have too long of a name
 */
public class OtherProblems {

    //for leetcode problem: https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/
    public boolean digitCount(String num) {
        // the length of num is the max limit you'll see in the string
        Map<Character, Integer> map = new HashMap<>();

        for (Character letter: num.toCharArray()){
            if (map.containsKey(letter)){
                int val = map.get(letter);
                map.put(letter, val + 1);
            } else {
                map.put(letter, 1);
            }
        }

        int counted = 0;
        for (int i = 0; i < num.length(); i++){
            char search = Character.forDigit(i, 10);
            int expectedNum = Character.getNumericValue(num.charAt(i));
            counted =  (map.containsKey(search)) ? map.get(search) : 0;
            if (counted != expectedNum) return false;
        }

        return true;
    }
}
