package com.florebencia.filsaime.implement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FibonacciTest {

    @Test
    void getValueIterativeTest(){
        Fibonacci fibonacci = new Fibonacci();
        int answer = fibonacci.getValueIterative(4);
        Assertions.assertEquals(2, answer);
    }

    @Test
    void getValueIterativeTest2(){
        Fibonacci fibonacci = new Fibonacci();
        int answer = fibonacci.getValueIterative(8);
        Assertions.assertEquals(13, answer);
    }

    @Test
    void getValueRecursiveTest(){
        Fibonacci fibonacci = new Fibonacci();
        int answer = fibonacci.getValueRecursive(4);
        Assertions.assertEquals(2, answer);
    }

    @Test
    void getValueRecursiveTest2(){
        Fibonacci fibonacci = new Fibonacci();
        int answer = fibonacci.getValueRecursive(8);
        Assertions.assertEquals(13, answer);
    }
}
