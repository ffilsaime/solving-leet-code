package com.florebencia.filsaime.implement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinarySearchTreeTest {

    @Test
    void breadthFirstSearchIterativeTest(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);
        List<Integer> list = bst.breadthFirstSearchIterative();
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(9, list.getFirst());
        Assertions.assertEquals(170, list.getLast());
        Assertions.assertEquals(4, list.get(1));
        Assertions.assertEquals(20, list.get(2));
        Assertions.assertEquals(1, list.get(3));
        Assertions.assertEquals(6, list.get(4));
        Assertions.assertEquals(15, list.get(5));
    }

    @Test
    void breadthFirstSearchRecursiveTest(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);
        BinarySearchTree.Node root = bst.getRoot();
        Deque<BinarySearchTree.Node> queue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> list = bst.breadthFirstSearchRecursive(queue, new ArrayList<>());
        Assertions.assertEquals(9, list.getFirst());
        Assertions.assertEquals(170, list.getLast());
        Assertions.assertEquals(4, list.get(1));
        Assertions.assertEquals(20, list.get(2));
        Assertions.assertEquals(1, list.get(3));
        Assertions.assertEquals(6, list.get(4));
        Assertions.assertEquals(15, list.get(5));
    }

    @Test
    void dFSInOrderTest(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);
        List<Integer> list = bst.dFSInOrder();
        Assertions.assertEquals(9, list.get(3));
        Assertions.assertEquals(170, list.getLast());
        Assertions.assertEquals(4, list.get(1));
        Assertions.assertEquals(20, list.get(5));
        Assertions.assertEquals(1, list.getFirst());
        Assertions.assertEquals(6, list.get(2));
        Assertions.assertEquals(15, list.get(4));
    }

    @Test
    void dFSInPreOrderTest(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);
        List<Integer> list = bst.dFSPreOrder();
        System.out.println("This is DFS preorder: " + list);
        Assertions.assertEquals(9, list.getFirst());
        Assertions.assertEquals(170, list.getLast());
        Assertions.assertEquals(4, list.get(1));
        Assertions.assertEquals(20, list.get(4));
        Assertions.assertEquals(1, list.get(2));
        Assertions.assertEquals(6, list.get(3));
        Assertions.assertEquals(15, list.get(5));
    }

    @Test
    void dFSInPostOrderTest(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);
        List<Integer> list = bst.dFSPostOrder();
        System.out.println("This is DFS postorder: " + list);
        Assertions.assertEquals(9, list.getLast());
        Assertions.assertEquals(170, list.get(4));
        Assertions.assertEquals(4, list.get(2));
        Assertions.assertEquals(20, list.get(5));
        Assertions.assertEquals(1, list.getFirst());
        Assertions.assertEquals(6, list.get(1));
        Assertions.assertEquals(15, list.get(3));
    }
}
