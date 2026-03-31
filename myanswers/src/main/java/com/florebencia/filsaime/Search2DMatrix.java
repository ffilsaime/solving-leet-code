package com.florebencia.filsaime;

//leetcode problem: https://leetcode.com/problems/search-a-2d-matrix/
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        // check the first value and last value of the row to see if that
        //target is there then do binary search
        int colLength = matrix[0].length;

        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == target){
                return true;
            } else if (matrix[i][colLength -1] == target){
                return true;
            } else {
                if (matrix[i][0] < target && matrix[i][colLength - 1] > target){
                    //do a while loop of binary search
                    return binarySearch(matrix[i], target);
                }
            }
        }

        return false;
    }

    public boolean binarySearch(int[] row, int target){
        int start = 0;
        int end = row.length - 1;
        int middle = start + (end - start)/2;

        while (start != middle && end != middle){
            if (target == row[start]){
                return true;
            } else if (target == row[middle]){
                return true;
            } else if (target == row[end]){
                return true;
            } else if (target > row[middle]){
                // start becomes middle, middle has a new value and end stays the same
                start = middle + 1;
                middle = start + (end - start)/2;
            } else {
                //target is < row[middle]
                //end becomes middle, middle has a new value, and start stays the same
                end = middle - 1;
                middle = start + (end - start)/2;
            }
        }

        return (row[start] == target) || (row[end] == target);
    }
}
