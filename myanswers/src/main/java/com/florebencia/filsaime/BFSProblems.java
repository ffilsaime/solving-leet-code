package com.florebencia.filsaime;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFSProblems {

    //for leetcode problem: https://leetcode.com/problems/binary-tree-level-order-traversal/description/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> solution = new ArrayList<>();

        if (root == null){
            return solution;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        bfs(queue, solution);
        return solution;
    }

    private void bfs(Queue<TreeNode> queue, List<List<Integer>> solution){
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }

                if (node.right != null){
                    queue.add(node.right);
                }
            }
            solution.add(subList);
        }
    }
}
