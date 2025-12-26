package com.florebencia.filsaime;

import com.florebencia.filsaime.implement.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        // order of binary search tree
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(20);
        bst.insert(1);
        bst.insert(6);
        bst.insert(15);
        bst.insert(170);
//                9
//        4              20
//    1        6      15      170
    }
}