package com.florebencia.filsaime.implement;

public class SelectionSort {

    public void sort(int[] arr){
        for(int j = 0; j < arr.length; j++){
            int swapIndex = j;
            for (int i = j; i < arr.length; i++){
                if (arr[swapIndex] > arr[i]){
                    swapIndex = i;
                }
            }
            int temp = arr[j];
            arr[j] = arr[swapIndex];
            arr[swapIndex] = temp;
        }
    }
}
