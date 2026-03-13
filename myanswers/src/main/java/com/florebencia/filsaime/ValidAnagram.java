package com.florebencia.filsaime;

import java.util.HashMap;
import java.util.Map;

//for leetcode problem: https://leetcode.com/problems/valid-anagram/submissions/1947276934/
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() == t.length() && s.length() == 1){
            return s.equals(t);
        }

        if(s.length() != t.length()) return false;

        Map<Character, Integer> sSet = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            int times = 0;
            if(sSet.containsKey(letter)){
                times = sSet.get(letter);
            }
            sSet.put(s.charAt(i), times + 1);
        }

        //now check if each letter in t is in s
        for (int i = 0; i < t.length(); i++){
            if(sSet.containsKey(t.charAt(i))){
                int times = sSet.get(t.charAt(i));
                sSet.put(t.charAt(i), times - 1);
            }
        }

        for(Integer times: sSet.values()){
            if (times != 0) return false;
        }

        return true;
    }
}
