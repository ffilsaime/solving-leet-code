package com.florebencia.filsaime.implement;

public class Factorial {

    public int recursiveFindValue(int i){
        // need base case
        if (i == 1){
            return 1;
        }
        // need recursive case
        return i * recursiveFindValue(i - 1);
    }

    public int iterativeFindValue(int i){
        int value = 1;
        while (i > 0){
            value *= i;
            i--;
        }
        return value;
    }
}
