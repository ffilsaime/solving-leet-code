package com.florebencia.filsaime.implement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSortTest {

    @Test
    void mergeTest(){
        MergeSort ms = new MergeSort();
        int[] array1 = new int[]{1,3,5};
        int[] array2 = new int[]{2,4};
        int[] result = ms.merge(array1,array2);
        Assertions.assertEquals(1, result[0]);
        Assertions.assertEquals(2, result[1]);
        Assertions.assertEquals(3, result[2]);
        Assertions.assertEquals(4, result[3]);
        Assertions.assertEquals(5, result[4]);
    }

    @Test
    void mergeOneItemTest(){
        MergeSort ms = new MergeSort();
        int[] array1 = new int[]{1};
        int[] array2 = new int[]{2};
        int[] result = ms.merge(array1,array2);
        Assertions.assertEquals(1, result[0]);
        Assertions.assertEquals(2, result[1]);
    }

    @Test
    void nullTest(){
        MergeSort ms = new MergeSort();
        int[] result = ms.sort(null);
        Assertions.assertNull(result);
    }

    @Test
    void emptyTest(){
        MergeSort ms = new MergeSort();
        int[] testArr = {};
        int[] result = ms.sort(testArr);
        Assertions.assertEquals(0, result.length);
    }

    @Test
    void sortTest(){
        MergeSort ms = new MergeSort();
        int[] arr = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        int[] result = ms.sort(arr);
        Assertions.assertEquals(0, result[0]);
        Assertions.assertEquals(1, result[1]);
        Assertions.assertEquals(2, result[2]);
        Assertions.assertEquals(4, result[3]);
        Assertions.assertEquals(5, result[4]);
        Assertions.assertEquals(6, result[5]);
        Assertions.assertEquals(44, result[6]);
        Assertions.assertEquals(63, result[7]);
        Assertions.assertEquals(87, result[8]);
        Assertions.assertEquals(99, result[9]);
        Assertions.assertEquals(283, result[10]);
    }

    @Test
    void sortTest2(){
        MergeSort ms = new MergeSort();
        int[] arr = {2, 1, 5, 63, 283, 0};
        int[] result = ms.sort(arr);
        Assertions.assertEquals(0, result[0]);
        Assertions.assertEquals(1, result[1]);
        Assertions.assertEquals(2, result[2]);
        Assertions.assertEquals(5, result[3]);
        Assertions.assertEquals(63, result[4]);
        Assertions.assertEquals(283, result[5]);
    }
}
