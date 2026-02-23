package com.florebencia.filsaime;

//leet code problem: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
public class FirstIndexOfString {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) return 0;

        int firstIndex = 0;
        int lengthOfNeedle = needle.length();
        for (int i = 0; i <= haystack.length() - lengthOfNeedle; i++) {
            if (haystack.substring(i, i + lengthOfNeedle).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
