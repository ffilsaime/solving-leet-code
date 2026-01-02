package com.florebencia.filsaime.implement;

public class InsertionSort {

    public void sort(int[] arr){
        // the outer loop goes through each element
        for (int i = 0; i < arr.length; i++){
            // the inner loop's job will be to move over elements "already sorted"
            // to make sure that the value is in the right place
            for (int j = 0; j < i ; j++){
                if (arr[i] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
