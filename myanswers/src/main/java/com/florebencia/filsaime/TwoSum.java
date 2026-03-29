package com.florebencia.filsaime;

//leetcode problem: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];

        if (numbers.length == 2){
            answer[0] = 1;
            answer[1] = 2;
            return answer;
        }

        // if I was allowed any space I would use a hashmap and
        // the key would be the value of the index and the value would be
        // the index itself
        int valToSearch = 0;
        int possibleIndex;
        for (int i = 0; i < numbers.length; i++){
            valToSearch = target - numbers[i];
            answer[0] = i + 1;
            possibleIndex = searchForValue(numbers, valToSearch, i + 1);
            if (possibleIndex != -1){
                answer[1] = possibleIndex + 1;
                return answer;
            } else {
                continue;
            }
        }

        return answer;
    }

    // searches for the index of the value of not return -1
    public int searchForValue(int[] searchArr, int searchFor, int startIndex){
        int lastIndex = searchArr.length - 1;
        // there's no more to search for
        if (startIndex == lastIndex) return startIndex;

        int middle = startIndex + (lastIndex - startIndex)/2;
        while (lastIndex > startIndex){
            if (searchFor == searchArr[startIndex]){
                return startIndex;
            } else if (searchFor == searchArr[middle]){
                return middle;
            } else if (searchFor == searchArr[lastIndex]) {
                return lastIndex;
            } else if (searchFor < searchArr[middle]){
                //start Index stays, change lastIndex to middle, and find a new middle
                lastIndex = middle - 1;
                middle = startIndex + (lastIndex - startIndex)/2;
            } else if (searchFor > searchArr[middle]){
                // startIndex changes to middle, middle changes, and lastIndex stays
                startIndex = middle + 1;
                middle = startIndex + (lastIndex - startIndex)/2;
            } else {
                // what if it's not found
                return -1;
            }
        }

        return -1;
    }
}
