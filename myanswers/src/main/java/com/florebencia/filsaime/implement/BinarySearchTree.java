package com.florebencia.filsaime.implement;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinarySearchTree {
    private int length =  0;
    private Node root;
    public BinarySearchTree() {
        //                9
        //        4              20
        //    1        6      15      170
    }

    public class Node  {
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
//            return "Node{ val=" + val + ", \nleft=" + left + ", \nright=" + right + '}';
            return "\t\t\t" + "  val\n" + "\t" + left + "\t\t\t" + right ;
        }
    }

    public void insert(int val) {
        //todo rewrite this in recursion
        if (root == null) {
            root = new Node(val, null, null);
            this.length++;
            return;
        }

        Node traveler = root;
        Node newNode = new Node(val, null, null);
        // should check if children are null not the node itself
//        while (traveler != null) {
//            if (val < traveler.val) {
//                traveler =  traveler.left;
//            } else {
//                traveler =  traveler.right;
//            }
//        }

        //todo might need to change this while loop
        while (traveler != null) {
            if (val < traveler.val) {
                if (traveler.left == null) {
                    traveler.left = newNode;
                    this.length++;
                    return;
                }
                traveler =  traveler.left;
            } else {
                if (traveler.right == null) {
                    traveler.right = newNode;
                    this.length++;
                    return;
                }
                traveler =  traveler.right;
            }
        }
    }

    public Node insertV2(int val) {
        if (root == null) {
            root = new Node(val, null, null);
            return root;
        }

        return insert(val, root);
    }

    public Node insert(int val, Node node) {
        if (val < node.val){
            if (node.left == null){
                Node newNode = new Node(val, null, null);
                node.left = newNode;
                return newNode;
            }
            return insert(val,node.left);
        }

        if (node.right == null){
            Node newNode = new Node(val, null, null);
            node.right = newNode;
            return newNode;
        }

        return insert(val,node.right);
    }

    public boolean lookup(int val) {
        Node traveler = root;
        while (traveler != null) {
            if (val == traveler.val) {
                return true;
            }

            if (val < traveler.val &&  traveler.left != null) {
                traveler = traveler.left;
                continue;
            }

            if (val > traveler.val &&  traveler.right != null) {
                traveler = traveler.right;
            }
        }
        return false;
    }

    public boolean lookupV2(int val) {
        if (root == null) {
            return false;
        }

        return lookup(val, root);
    }

    public boolean lookup(int val, Node node) {
        if (val == node.val) {
            return true;
        }

        if (val < node.val &&  node.left != null) {
            return lookup(val, node.left);
        }
        if (val > node.val &&  node.right != null) {
            return lookup(val, node.right);
        }

        return false;
    }

    public boolean remove(int val) {
        // if it's a parent node you must take the children and send them to the appropriate parent
        // you will also need a previous node to be the new parent
        //todo will do this with recursion
        return false;
    }

    public Node traverse(Node root){
        //todo traverse through the whole tree with recursion
        return null;
    }

    public List<Integer> breadthFirstSearchIterative() {
        List<Integer> result = new ArrayList<>();
        // this is just review I didn't implement this myself
        Node pointer = this.root;
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(pointer);

        while (!queue.isEmpty()) {
            pointer =  queue.poll();
            result.add(pointer.val);
            if (pointer.left != null) {
                queue.add(pointer.left);
            }

            if (pointer.right != null) {
                queue.add(pointer.right);
            }
        }

        System.out.println("Breadth First Search Iterative: " + result);

        return result;
    }

    public List<Integer> breadthFirstSearchRecursive(Deque<Node> queue, List<Integer> result) {
        // this is just review I didn't implement this myself
        if (queue.isEmpty()) {
            System.out.println("Breadth First Search Recursive: " + result);
            return result;
        }

        Node pointer = queue.poll();
        result.add(pointer.val);

        if (pointer.left != null) {
            queue.add(pointer.left);
        }

        if (pointer.right != null) {
            queue.add(pointer.right);
        }

        return breadthFirstSearchRecursive(queue, result);
    }

    public Node getRoot() {
        return root;
    }

    public List<Integer> dFSInOrder(){
        // this is just review I didn't implement this myself
        return traversInOrder(this.root, new ArrayList<>());
    }

    private List<Integer> traversInOrder(Node node, ArrayList<Integer> list) {
        if (node.left != null) {
            traversInOrder(node.left, list);
        }

        list.add(node.val);

        if (node.right != null) {
            traversInOrder(node.right, list);
        }

        System.out.println("This is DFS in order: " + list);
        return list;
    }

    public List<Integer> dFSPostOrder(){
        // this is just review I didn't implement this myself
        return traversPostOrder(this.root, new ArrayList<>());
    }

    private List<Integer> traversPostOrder(Node node, ArrayList<Integer> list) {
        if (node.left != null) {
            traversPostOrder(node.left, list);
        }

        if (node.right != null) {
            traversPostOrder(node.right, list);
        }

        list.add(node.val);
        return list;
    }

    public List<Integer> dFSPreOrder(){
        // this is just review I didn't implement this myself
        return traversPreOrder(this.root, new ArrayList<>());
    }

    private List<Integer> traversPreOrder(Node node, ArrayList<Integer> list) {
        list.add(node.val);

        if (node.left != null) {
            traversPreOrder(node.left, list);
        }

        if (node.right != null) {
            traversPreOrder(node.right, list);
        }

        return list;
    }
}
