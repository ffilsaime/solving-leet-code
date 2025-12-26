package com.florebencia.filsaime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveDuplicatesFromSortedArrayTest {

    private RemoveDuplicatesFromSortedArray rdfsa =  new RemoveDuplicatesFromSortedArray();
    @Test
    public void removeDuplicates() {
        int[] testArray = {1,1,2};
        int answer =  rdfsa.removeDuplicates(testArray);
        Assertions.assertEquals(2, answer);
        Assertions.assertEquals(1, testArray[0]);
        Assertions.assertEquals(2, testArray[1]);
        Assertions.assertEquals(0, testArray[2]);
    }

    @Test
    public void testRemoveDuplicates() {
        int[] testArray = {0,0,1,1,1,2,2,3,3,4};
        int answer =  rdfsa.removeDuplicates(testArray);
        Assertions.assertEquals(5, answer);
        Assertions.assertEquals(0, testArray[0]);
        Assertions.assertEquals(1, testArray[1]);
        Assertions.assertEquals(2, testArray[2]);
        Assertions.assertEquals(3, testArray[3]);
        Assertions.assertEquals(4, testArray[4]);
        Assertions.assertEquals(0, testArray[5]);
    }
}
