package com.florebencia.filsaime;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//leetcode problem: https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // turn the whole string to lowercase
        // have a pattern to tell if a string is alphanumeric
        // when a char is not alphanumeric move the pointer
        String testStr = s.toLowerCase();
        int startPos = 0;
        int endPos = s.length() - 1;
        Pattern p = Pattern.compile("[a-zA-Z0-9]*");
        //Pattern p = Pattern.compile("geeks");

        while (!(endPos < startPos)){
            String character = String.valueOf(s.charAt(startPos));
            Matcher m = p.matcher(character);
            if(!m.matches()){
                startPos += 1;
                continue;
            }
            character = String.valueOf(s.charAt(endPos));
            m = p.matcher(character);
            if(!m.matches()){
                endPos -= 1;
                continue;
            }

            if(s.charAt(endPos) != s.charAt(startPos)){
                return false;
            }
        }

        return true;
    }
}
