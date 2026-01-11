package com.florebencia.filsaime;

import java.util.HashMap;
import java.util.Map;

/**
 * For the leetcode problem: https://leetcode.com/problems/check-if-the-sentence-is-pangram/editorial/?source=submission-ac
 */
public class SentencePangram {

    public boolean checkIfPangram(String sentence) {
        char[] chars = sentence.toCharArray();
        Map<Character, Integer> helperMap = new HashMap<>();

        for (int i = 0; i < sentence.length(); i++){
            if (!helperMap.containsKey(chars[i])) {
                helperMap.put(chars[i], 1);
            }
        }

        return (helperMap.size() == 26);
    }
}
