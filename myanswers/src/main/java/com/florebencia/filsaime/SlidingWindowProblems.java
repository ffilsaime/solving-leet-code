package com.florebencia.filsaime;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowProblems {
    //for leetcode problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public int lengthOfLongestSubstring(String s) {
        // todo: I need to come back to this problem to make it more efficient
        if (s.length() == 0) return 0;

        Map<Character, Integer> tracker = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            System.out.println("Current Letter is " + letter);
            if (tracker.containsKey(letter)){
                System.out.println("Sub Length before moving left is " + tracker.size());
                maxLength = Math.max(tracker.size(), maxLength);
                System.out.println("Max Length is " + maxLength);
                int index = tracker.get(letter);
                while (left <= index) {
                    tracker.remove(s.charAt(left));
                    left += 1;
                }
                System.out.println("Sub Length is " + tracker.size());
                tracker.put(letter, i);
            } else {
                tracker.put(letter, i);
            }
        }

        maxLength = Math.max(tracker.size(), maxLength);

        return maxLength;
    }
}
