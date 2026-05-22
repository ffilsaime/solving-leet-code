package com.florebencia.filsaime;

import java.util.ArrayList;
import java.util.List;

// my solution for leetcode problem: https://leetcode.com/problems/pascals-triangle/description/
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        return pascalTriangle(answer, numRows, 1);
    }

    private List<List<Integer>> pascalTriangle(List<List<Integer>> list, int numRows, int currentRow){
        // remember the current row starts at 1 instead of 0
        List<Integer> subList = new ArrayList<>();

        if (currentRow == 1){
            subList.add(1);
        } else {
            for (int i = 0; i < currentRow; i++){
                if (i == 0 || i == currentRow - 1){
                    subList.add(1);
                } else {
                    //get the previous rows i element and i - 1 element
                    int row = currentRow - 2;
                    int newVal = list.get(row).get(i) + list.get(row).get(i - 1);
                    subList.add(newVal);
                }
            }
        }

        list.add(subList);

        if (currentRow == numRows){
            return list;
        } else {
            return pascalTriangle(list, numRows, currentRow + 1);
        }
    }
}
