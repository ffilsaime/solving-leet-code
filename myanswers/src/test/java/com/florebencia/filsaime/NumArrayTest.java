package com.florebencia.filsaime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumArrayTest {

    @Test
    void sumRangeTest(){
        int[] testArr = {-2,0,3,-5,2,-1};
        NumArray numArray = new NumArray(testArr);
        int sum = numArray.sumRange(0,2);
        int sum2 = numArray.sumRange(2,5);
        int sum3 = numArray.sumRange(0,5);

        Assertions.assertEquals(1, sum);
        Assertions.assertEquals(-1, sum2);
        Assertions.assertEquals(-3, sum3);
    }
}
