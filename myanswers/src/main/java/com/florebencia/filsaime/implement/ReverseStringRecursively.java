package com.florebencia.filsaime.implement;

/**
 * This is for attempting to reverse a string with recursion
 */
public class ReverseStringRecursively {

    // my idea is to have the recursive case be substrings
    // base case would be one letter

    public String reverseString(String s) {
        if (s == null || s.isBlank()){
            return "";
        }

        int length = s.length();

        if (length == 1){
            return s;
        }

        return s.substring(length - 1) +  reverseString(s.substring(0, length - 1));
    }
}
