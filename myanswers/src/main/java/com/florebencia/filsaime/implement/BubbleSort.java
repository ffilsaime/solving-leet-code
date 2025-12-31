package com.florebencia.filsaime.implement;

public class BubbleSort {

    public void sort(int[] toBeSorted) {
        if (toBeSorted == null) {
            return;
        }

        if (toBeSorted.length <= 1) {
            return;
        }

        for(int i = toBeSorted.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (toBeSorted[j] > toBeSorted[j+1]){
                    System.out.println("Comparing the numbers " + toBeSorted[j] +  " and " + toBeSorted[j+1]);
                    int temp = toBeSorted[j];
                    toBeSorted[j] = toBeSorted[j+1];
                    toBeSorted[j+1] = temp;
                }
            }
        }
    }
}
