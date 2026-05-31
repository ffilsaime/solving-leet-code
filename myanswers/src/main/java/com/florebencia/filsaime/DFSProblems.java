package com.florebencia.filsaime;

import java.util.HashSet;
import java.util.Set;

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

    // for leetcode problem: https://leetcode.com/problems/flood-fill/description/
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Set<String> visited = new HashSet<>();
        int[][] directions = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        int dColor = image[sr][sc];
        if (dColor != color){
            dfs(image, sr, sc, color, visited, dColor, directions);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, Set<String> visited, int defaultColor, int[][] directions){
        if (visited.contains(r + "," + c)) return;
        if (r < 0 || r >= image.length) return;
        if (c < 0 || c >= image[0].length) return;

        // we should be somewhere on the grid still
        if (image[r][c] != defaultColor) return;

        image[r][c] = color;
        visited.add(r + "," + c);

        for (int[] d: directions){
            dfs(image, r + d[0], c + d[1], color, visited, defaultColor, directions);
        }
    }
    // end of leetcode problem
}
