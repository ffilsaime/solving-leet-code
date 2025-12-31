package com.florebencia.filsaime.implement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SelectionSortTest {

    @Test
    void selectionSortTest() {
        int[] arr = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        Assertions.assertEquals(0, arr[0]);
        Assertions.assertEquals(1, arr[1]);
        Assertions.assertEquals(2, arr[2]);
        Assertions.assertEquals(4, arr[3]);
        Assertions.assertEquals(5, arr[4]);
        Assertions.assertEquals(6, arr[5]);
        Assertions.assertEquals(44, arr[6]);
        Assertions.assertEquals(63, arr[7]);
        Assertions.assertEquals(87, arr[8]);
        Assertions.assertEquals(99, arr[9]);
        Assertions.assertEquals(283, arr[10]);
    }
}
