package com.florebencia.filsaime;

import java.util.*;

public class HeapProblems {

    //for leetcode problem: https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/description/
    public int largestInteger(int num) {
        PriorityQueue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());
        // Have two max heaps one for even numbers and one for odd
        // pop from both heap whenever there's an odd or even number respectively
        // add that value to the string builder
        int solution = 0;
        String numStr = String.valueOf(num);
        for (int i = 0; i < numStr.length(); i++){
            int value = numStr.charAt(i) - '0';
            setUpTwoHeaps(even, odd, value);
        }

        for (int i = 0; i < numStr.length(); i++){
            solution *= 10;
            int value = numStr.charAt(i) - '0';
            if (value % 2 == 0){
                int popped = even.poll();
                solution += popped;
            } else {
                int popped = odd.poll();
                solution += popped;
            }
        }

        return solution;
    }

    private void setUpTwoHeaps(PriorityQueue<Integer> even, PriorityQueue<Integer> odd, int value){
        if (value % 2 == 0){
            even.add(value);
        } else {
            odd.add(value);
        }
    }
    //end of leetcode problem

    //for leetcode problem: https://leetcode.com/problems/merge-sorted-array/description/
    class ArrayComparator implements Comparator<int[]> {
        public int compare(int[] arr, int[] arr2){
            return arr[0] - arr2[0];
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0){
            return;
        }

        if (m == 0){
            //set up all of the values of nums2 into nums1
            for (int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
            return;
        }

        PriorityQueue<int[]> tracker = new PriorityQueue<>(new ArrayComparator());
        int index = 0;
        // first index is the val; second index is the array #; last index is the index in the array itself
        int[] start = {nums1[0], 1, 0};
        int[] start2 = {nums2[0], 2, 0};
        int[] sorted = new int[nums1.length];
        tracker.add(start);
        tracker.add(start2);

        //instead of replacing the values in nums1 put in in another array and change nums1's values to that
        while (!tracker.isEmpty()){
            int[] lowest = tracker.poll();
            sorted[index] = lowest[0];
            int[] newArr = new int[3];
            int newIndex = lowest[2] + 1;
            if (lowest[1] == 1){
                // it comes from the first array
                if (newIndex < m){
                    newArr[0] = nums1[newIndex];
                    newArr[1] = 1;
                    newArr[2] = newIndex;
                    tracker.add(newArr);
                }
            } else {
                if (newIndex < n){
                    newArr[0] = nums2[newIndex];
                    newArr[1] = 2;
                    newArr[2] = newIndex;
                    tracker.add(newArr);
                }
            }
            index++;
        }

        for (int i = 0; i < nums1.length; i++){
            nums1[i] = sorted[i];
        }
    }
    //end of leetcode problem

    //for leetcode problem: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 1){
            return matrix[0][0];
        }

        int[] sorted = new int[matrix.length * matrix.length];
        PriorityQueue<int[]> tracker = new PriorityQueue<>(new ArrayComparator());
        int index = 0;
        //start adding the first values of each row
        for (int i = 0; i < matrix.length; i++){
            // 0 index is the value; 1 index is the row; 2 index is the column
            int[] start = new int[3];
            start[0] = matrix[i][0];
            start[1] = i;
            start[2] = 0;
            tracker.add(start);
        }

        while (!tracker.isEmpty()){
            int[] lowest = tracker.poll();
            sorted[index] = lowest[0];
            int row = lowest[1];
            int col = lowest[2] + 1;
            if (col < matrix.length){
                int[] newArr = new int[3];
                newArr[0] = matrix[row][col];
                newArr[1] = row;
                newArr[2] = col;
                tracker.add(newArr);
            }
            index++;
        }

        return sorted[k - 1];
    }

    //for leetcode problem: https://leetcode.com/problems/third-maximum-number/description/
    public int thirdMax(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        //you need a min heap
        PriorityQueue<Integer> tracker = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();

        int lastIndex = 0;
        while (set.size() < 3 && lastIndex < nums.length){
            //setting up the queue
            if (!set.contains(nums[lastIndex])){
                tracker.add(nums[lastIndex]);
                set.add(nums[lastIndex]);
            }
            lastIndex++;
        }

        for(int i = lastIndex; i < nums.length; i++){
            if(nums[i] > tracker.peek() && !set.contains(nums[i])){
                tracker.poll();
                tracker.add(nums[i]);
                set.add(nums[i]);
            }
        }

        if (tracker.size() == 3 || tracker.size() == 1){
            return tracker.peek();
        }

        else if (tracker.size() == 2){
            int one = tracker.poll();
            int two = tracker.poll();
            return Math.max(one, two);
        }

        else {
            if (tracker.size() > 3){
                while (tracker.size() > 3){
                    tracker.poll();
                }
            }
        }

        return tracker.peek();
    }

    //for leetcode: https://leetcode.com/problems/top-k-frequent-elements/description/
    class FrequencyComparator implements Comparator<int[]> {
        //going to store the frequency at index 1
        public int compare(int[] arr, int[] arr2){
            int value = arr[1] - arr2[1];
            if (value == 0){
                return 0;
            }else {
                return -value;
            }
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1){
            return nums;
        }

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> tracker = new PriorityQueue<>(new FrequencyComparator());

        for (Integer number: nums){
            if(!map.containsKey(number)){
                map.put(number, 1);
            } else {
                int value = map.get(number);
                map.put(number, value + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            int[] add = new int[2];
            add[0] = entry.getKey();
            add[1] = entry.getValue();
            tracker.add(add);
        }

        int count = 1;
        int[] solution = new int[k];
        int index = 0;
        while (count <= k){
            if (!tracker.isEmpty()){
                int[] element = tracker.poll();
                solution[index] = element[0];
                index++;
                count++;
            }
        }

        return solution;
    }
    // end of leetcode problem

    //for leetcode problem: https://leetcode.com/problems/top-k-frequent-words/description
    class WordCount {
        private String word;
        private int count;

        public void setWord(String aWord){
            word = aWord;
        }

        public void setCount(int newCount){
            count = newCount;
        }

        public String getWord(){
            return word;
        }

        public int getCount(){
            return count;
        }
    }

    class WordCountComparator implements Comparator<WordCount> {

        public int compare(WordCount wc, WordCount wc2){
            if (wc.getCount() == wc2.getCount()){
                return (wc.getWord().compareTo(wc2.getWord()));
            }

            return -1 * (wc.getCount() - wc2.getCount());
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<WordCount> maxHeap = new PriorityQueue<>(new WordCountComparator());
        Map<String, Integer> tracker = new HashMap<>();
        for (String word: words) {
            if (tracker.containsKey(word)){
                tracker.put(word, tracker.get(word) + 1);
            } else {
                tracker.put(word, 1);
            }
        }

        tracker.forEach((key, v) -> {
            WordCount wordCount = new WordCount();
            wordCount.setWord(key);
            wordCount.setCount(v);
            maxHeap.add(wordCount);
        });

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < k; i++){
            answer.add(maxHeap.poll().getWord());
        }

        return answer;
    }
    //end of leetcode problem
}
