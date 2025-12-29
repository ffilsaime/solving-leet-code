package com.florebencia.filsaime.implement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactorialTest {

    @Test
    void test5() {
        Factorial f = new Factorial();
        int iAnswer = f.iterativeFindValue(5);
        int rAnswer = f.recursiveFindValue(5);

        Assertions.assertEquals(120, iAnswer);
        Assertions.assertEquals(120, rAnswer);
    }
}
