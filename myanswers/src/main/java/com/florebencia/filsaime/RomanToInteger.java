package com.florebencia.filsaime;

public class RomanToInteger {
    public static void main(String[] args) {
        String toSolve = "";
        System.out.println("This is the number value of " + toSolve + ": " + romanToInt(toSolve));
    }

    public static int romanToInt(String s) {
        return 0;
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