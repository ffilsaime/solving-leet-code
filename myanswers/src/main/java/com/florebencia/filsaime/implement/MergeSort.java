package com.florebencia.filsaime.implement;

import java.util.Arrays;

public class MergeSort {

    public int[] sort(int[] arr){
        // always gotta check if an array is null or empty
        if (arr==null || arr.length==0){
            return arr;
        }

        // the base case is when there's only 1 element in the subarray
        if (arr.length == 1){
            return arr;
        }

        // split the primary array in half
        // this takes into account if the array size is an odd number
        int[] left = Arrays.copyOfRange(arr, 0, arr.length/2);
        int[] right = Arrays.copyOfRange(arr, arr.length/2, arr.length);

        return merge(sort(left),sort(right));

    }

    public int[] merge(int[] left, int[] right){
        // adding the lengths of both arrays as opposed to multiplying one of them by two
        //ensures that if one array is bigger than the other, all elements will be accounted for
        int newLength = left.length+right.length;
        int[] result = new int[newLength];

        // index keeps track of the index in the result array
        // rightIndex and leftIndex keeps track of those indexes of their respective arrays
        int index = 0;
        int rightIndex = 0;
        int leftIndex = 0;

        while ((rightIndex != right.length) && (leftIndex != left.length)) {
            if (left[leftIndex] < right[rightIndex]) {
                result[index] = left[leftIndex];
                leftIndex++;
            } else {
                result[index] = right[rightIndex];
                rightIndex++;
            }
            index++;
        }

        //System.out.println("Left Index: " + leftIndex + ". Right Index: " + rightIndex);

        // last two if statements checks for leftover elements missed
        if (leftIndex < left.length && left.length >= right.length) {
            for (int i = leftIndex; i < left.length; i++) {
                result[index] = left[i];
                index++;
            }
        }
        if (rightIndex < right.length && right.length >= left.length) {
            for (int i = rightIndex; i < right.length; i++) {
                result[index] = right[i];
                index++;
            }
        }
        return result;
    }
}
