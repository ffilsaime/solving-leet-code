package com.florebencia.filsaime.implement;

public class BinarySearchTree {
    private int length =  0;
    private Node root;
    public BinarySearchTree() {}

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

    public boolean remove(int val) {
        // if it's a parent node you must take the children and send them to the appropriate parent
        // you will also need a previous node to be the new parent
        //todo will do this with recusion
        return false;
    }
}
