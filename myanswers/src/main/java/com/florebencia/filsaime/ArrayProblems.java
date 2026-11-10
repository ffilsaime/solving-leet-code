package com.florebencia.filsaime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayProblems {

    //for leetcode problem: https://leetcode.com/problems/rotate-array/description/
    public void rotate(int[] nums, int k) {
        if (nums.length == 1){
            return;
        }

        //todo what if you rotate the list more times than it's size?
        //how about find the modulo of k and use that as a basis
        int newK = (k > nums.length) ? k % nums.length : k;
        System.out.println("This is the value of newK: " + newK);

        int[] endingIndices = new int[newK];
        int index = nums.length - newK;
        int j = 0;

        //getting the last k elements so I can put them in the front later
        for(int i = index; i < nums.length; i++){
            endingIndices[j] = nums[i];
            j++;
        }

        System.out.println("endingIndices looks like this: " +  Arrays.toString(endingIndices));

        // shifting the rest of the numbers to the right
        for (int i = index - 1; i >= 0; i--){
            nums[i + newK] = nums[i];
        }

        System.out.println("endingIndices looks like this: " +  Arrays.toString(nums));

        for (int i = 0; i < newK; i++){
            nums[i] = endingIndices[i];
        }
    }

    //for leetcode problem: https://leetcode.com/problems/spiral-matrix/description/
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        // right, down, left, up...
        // values hold the lowest x value to touch, highest x value, lowest y value,
        // highest y value
        int[] values = new int[4];
        values[0] = 0;
        values[1] = matrix[0].length - 1;
        values[2] = 0;
        values[3] = matrix.length - 1;
        doSpiral(answer, matrix, values, "RIGHT");
        return answer;
    }

    private void doSpiral(List<Integer> answer, int[][] matrix, int[] indices, String direction){
        String newDirection;

        if(direction.isBlank()){
            System.out.println("No direction was set.");
            return;
        }

        if (indices[0] > indices[1] || indices[2] > indices[3]){
            return;
        }

        if(direction.equalsIgnoreCase("RIGHT")){
            //to the right
            int index = indices[2]; //y value needs to be the same
            for(int i = indices[0]; i <= indices[1]; i++){
                answer.add(matrix[index][i]);
            }
            indices[2]++;
            newDirection = "DOWN";
        } else if(direction.equalsIgnoreCase("down")){
            //down
            int index = indices[1]; //x value needs to be the same
            for (int i = indices[2]; i <= indices[3]; i++){
                answer.add(matrix[i][index]);
            }
            indices[1]--;
            newDirection = "LEFT";
        } else if (direction.equalsIgnoreCase("left")){
            //to the left
            int index = indices[3]; //y values needs to stay the same
            for (int i = indices[1]; i >= indices[0]; i--){
                answer.add(matrix[index][i]);
            }
            indices[3]--;
            newDirection = "UP";
        } else {
            //going up
            int index = indices[0]; //x-value needs to stay the same
            for (int i = indices[3]; i >= indices[2]; i--){
                answer.add(matrix[i][index]);
            }
            indices[0]++;
            newDirection = "RIGHT";
        }

        doSpiral(answer, matrix, indices, newDirection);
    }
}
