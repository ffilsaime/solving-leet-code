package com.florebencia.filsaime;

public class RomanToInteger {
    public int romanToInt(String s) {
        int solution = 0;
        String prevLetter = "";
        int prevValue = 0;

        // can I use substrings????
        if (s.length() == 1){
            return romanReader(s);
        }

        for (int i = 0; i < s.length(); i++){
            String currentLetter = (i == (s.length() - 1)) ? s.substring(i) : s.substring(i, i + 1);
            if (currentLetter.equals(prevLetter)){
                int value = romanReader(currentLetter);
                solution += value;
                prevValue = value;
                prevLetter = currentLetter;
            } else {
                // remember you can concatenate two strings to make a new one
                int value = romanReader(prevLetter + currentLetter);
                if (value != 0){
                    solution -= prevValue;
                    solution += value;
                    prevValue = value;
                    prevLetter = currentLetter;
                } else {
                    value = romanReader(currentLetter);
                    solution += value;
                    prevValue = value;
                    prevLetter = currentLetter;
                }
            }
        }
        return solution;
    }

    // this reads the roman letters and turns them into integers
    public int romanReader(String s){
        // do the harder values first
        return switch (s) {
            case "IV" -> 4;
            case "V" -> 5;
            case "IX" -> 9;
            case "I" -> 1;
            case "XL" -> 40;
            case "XC" -> 90;
            case "X" -> 10;
            case "CD" -> 400;
            case "CM" -> 900;
            case "C" -> 100;
            case "L" -> 50;
            case "D" -> 500;
            case "M" -> 1000;
            default -> 0;
        };
    }
}