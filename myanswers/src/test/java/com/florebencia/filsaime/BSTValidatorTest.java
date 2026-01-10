package com.florebencia.filsaime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BSTValidatorTest {

    @Test
    void isValidBSTTest() {
        BSTValidator bst = new BSTValidator();
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        boolean result = bst.isValidBST();
        Assertions.assertTrue(result);
    }

    @Test
    void isValidBSTBadTreeTest() {
        BSTValidator bst = new BSTValidator();
        bst.insert(5);

        bst.insert(1);
        bst.insert(3);
        boolean result = bst.isValidBST();
        Assertions.assertTrue(result);
    }
}
