package com.florebencia.filsaime;

//for leetcode problem: https://leetcode.com/problems/determine-color-of-a-chessboard-square/description/
public class CheckerBoard {

    public boolean squareIsWhite(String coordinates) {
        //return true if white and false if black

        //a1 is black
        boolean answer = false;
        String[] bottomCoords = {"a", "b", "c", "d", "e", "f", "g", "h"};
        int pointer = 0;

        //go to the right column
        while (!coordinates.substring(0, 1).equals(bottomCoords[pointer])){
            pointer += 1;
            answer = !answer;
        }

        //go to the right row
        int val = Integer.valueOf(coordinates.substring(1));
        if (val % 2 == 0){
            answer = !answer;
        }

        //move to the appropriate row and column changing the value as you go
        return answer;
    }
}
