package com.florebencia.filsaime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanToIntegerTest {

    RomanToInteger romanToInteger = new RomanToInteger();

    @Test
    void defaultRomanReaderTest(){
        assertEquals(1, romanToInteger.romanReader("I"));
        assertEquals(5, romanToInteger.romanReader("V"));
        assertEquals(10, romanToInteger.romanReader("X"));
        assertEquals(50, romanToInteger.romanReader("L"));
        assertEquals(100, romanToInteger.romanReader("C"));
        assertEquals(500, romanToInteger.romanReader("D"));
        assertEquals(1000, romanToInteger.romanReader("M"));
    }

    @Test
    void specialRomanReaderTest(){
        assertEquals(4, romanToInteger.romanReader("IV"));
        assertEquals(9, romanToInteger.romanReader("IX"));
        assertEquals(40, romanToInteger.romanReader("XL"));
        assertEquals(90, romanToInteger.romanReader("XC"));
        assertEquals(400, romanToInteger.romanReader("CD"));
        assertEquals(900, romanToInteger.romanReader("CM"));
    }
}
