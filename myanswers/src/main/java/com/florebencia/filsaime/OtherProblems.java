package com.florebencia.filsaime;

import java.util.*;

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

    //for leetcode problem: https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/description/
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        // use a hashmap for this
        Map<Integer, Integer> tracker = new HashMap<>();
        // the key is the occurance and the value is which index it's found

        int occurances = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == x){
                occurances += 1;
                tracker.put(occurances, i);
            }
        }

        int[] solution = new int[queries.length];
        for (int i = 0; i < queries.length; i++){
            int index = tracker.getOrDefault(queries[i], -1);
            solution[i] = index;
        }

        return solution;
    }

    //for leetcode problem: https://leetcode.com/problems/fizz-buzz/description/
    public List<String> fizzBuzz(int n) {
        List<String> solution = new ArrayList<>();
        for (int i = 1; i < n + 1; i++){
            solution.add(returnAnswerString(i));
        }
        return solution;
    }

    private String returnAnswerString(int i){
        if (i % 3 == 0 && i % 5 == 0) return "FizzBuzz";
        else if (i % 3 == 0) return "Fizz";
        else if (i % 5 == 0) return "Buzz";
        else return String.valueOf(i);
    }
    // end of leetcode problem Fizz Buzz

    //for leetcode problem: https://leetcode.com/problems/slowest-key/description/
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        // when a new key is pressed it means the previous one was released
        //treat the string as a charArray

        if (releaseTimes.length == 1){
            return keysPressed.charAt(0);
        }

        int maxDuration = releaseTimes[0];
        char pressed = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++){
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            char newPressed = keysPressed.charAt(i);
            if (duration > maxDuration){
                pressed = newPressed;
                maxDuration = duration;
            } else if (duration == maxDuration && pressed < newPressed){
                pressed = newPressed;
            }
        }

        return pressed;
    }

    //for leetcode problem: https://leetcode.com/problems/kth-largest-element-in-an-array/description/
    public int findKthLargest(int[] nums, int k) {
        // it's one of the slower algos but I should come back to this and maybe I can maket this faster?
        // use a PriorityQueue and pop k amount of times?
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (Integer elem : nums){
            queue.add(elem);
        }

        for (int i = 0; i < k - 1; i++){
            queue.poll();
        }

        return queue.peek();
    }
}
