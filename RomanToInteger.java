public class RomanToInteger {
    public static void main(String[] args) {

    }

    public int romanToInt(String s) {
        /** Key
        I=1 V=5 X=10 L=50 C=100 D=500 M=1000
         Exceptions:
         I can be placed before V (5) and X (10) to make 4 and 9.
         X can be placed before L (50) and C (100) to make 40 and 90.
         C can be placed before D (500) and M (1000) to make 400 and 900.
         */
        int ones = 0;
        int five = 5;
        int tens = 0;
        int fifty = 50;
        int hundreds = 0;
        int fivehundred = 500;
        int thousands = 0;
    }
}