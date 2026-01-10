package com.florebencia.filsaime;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * link to url: https://leetcode.com/problems/validate-binary-search-tree/description/
 */
public class BSTValidator {
    private TreeNode root;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // I know to use BFS for this but then what...

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> badNodes = new ArrayList<>();
        breadthFirstSearch(queue, badNodes);
        return badNodes.isEmpty();
    }

    public void breadthFirstSearch(Deque<TreeNode> queue, List<Integer> badNodes) {
        if (queue.isEmpty()) {
            System.out.println("Breadth First Search's bad Nodes': " + badNodes);
            return;
        }

        TreeNode pointer = queue.poll();
        //badNodes.add(pointer.val);

        if (pointer.left != null) {
            if (pointer.left.val >= pointer.val) {
                badNodes.add(pointer.left.val);
            }
            queue.add(pointer.left);
        }

        if (pointer.right != null) {
            if (pointer.right.val <= pointer.val) {
                badNodes.add(pointer.right.val);
            }
            queue.add(pointer.right);
        }

        breadthFirstSearch(queue, badNodes);
    }

    public TreeNode insert(int val) {
        if (root == null) {
            root = new TreeNode(val, null, null);
            return root;
        }

        return insert(val, root);
    }

    public TreeNode insert(int val, TreeNode node) {
        if (val < node.val){
            if (node.left == null){
                TreeNode newNode = new TreeNode(val, null, null);
                node.left = newNode;
                return newNode;
            }
            return insert(val,node.left);
        }

        if (node.right == null){
            TreeNode newNode = new TreeNode(val, null, null);
            node.right = newNode;
            return newNode;
        }

        return insert(val,node.right);
    }

    public boolean isValidBST(){
        return isValidBST(root);
    }

    public void insertLeft(TreeNode parent, TreeNode child) {
        if (parent != null) {
            parent.left = child;
        }
    }

    public void insertRight(TreeNode parent, TreeNode child) {
        if (parent != null) {
            parent.right = child;
        }
    }
}
