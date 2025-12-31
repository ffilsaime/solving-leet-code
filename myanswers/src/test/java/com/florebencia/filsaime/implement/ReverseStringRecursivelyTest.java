package com.florebencia.filsaime.implement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseStringRecursivelyTest {

    @Test
    public void reverseStringEmptyOrNullTest() {
        ReverseStringRecursively reverseStringRecursively = new ReverseStringRecursively();
        String test = reverseStringRecursively.reverseString("");
        String test2 = reverseStringRecursively.reverseString(null);
        Assertions.assertEquals("", test);
        Assertions.assertEquals("", test2);
    }

    @Test
    public void reverseStringTest() {
        ReverseStringRecursively reverseStringRecursively = new ReverseStringRecursively();
        String test = reverseStringRecursively.reverseString("abcd");
        Assertions.assertEquals("dcba", test);
    }

    @Test
    public void reverseStringTest2() {
        ReverseStringRecursively reverseStringRecursively = new ReverseStringRecursively();
        String test = reverseStringRecursively.reverseString("djsh");
        Assertions.assertEquals("hsjd", test);
    }
}
