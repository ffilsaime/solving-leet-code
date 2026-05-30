package com.florebencia.filsaime;

public class DFSProblems {
    private int max = 0;

     private class TreeNode {
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

    //for leetcode problem: https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        dfs(root, 1);
        return max;
    }

    private void dfs(TreeNode node, int height){
        if (node == null){
            return;
        }

        // increase the height because you are in a new node
        max = Math.max(height, max);
        dfs(node.left, height + 1);
        dfs(node.right, height + 1);
    }
    // end of leetcode problems

    //for leetcode problem: https://leetcode.com/problems/path-sum/description/
    public Boolean pathSum(TreeNode root, Integer target) {
        if (root == null) return false;

        return dfs(root, target, 0);
    }

    private boolean dfs(TreeNode node, Integer target, int sum){
        if (node == null){
            return false;
        }

        if (node.left == null && node.right == null) {
            return sum + node.val == target;
        }

        boolean path = dfs(node.left, target, sum + node.val);
        boolean path2 = dfs(node.right, target, sum + node.val);

        return path || path2;
    }
    // end of leetcode problem
}
