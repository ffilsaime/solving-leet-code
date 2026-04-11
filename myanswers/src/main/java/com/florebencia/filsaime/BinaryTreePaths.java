package com.florebencia.filsaime;

import java.util.ArrayList;
import java.util.List;

// for this leetcode problem: https://leetcode.com/problems/binary-tree-paths/description/?envType=problem-list-v2&envId=backtracking
public class BinaryTreePaths {

    public List<String> binaryTreePaths(BSTValidator.TreeNode root) {
        List<String> answer = new ArrayList<>();
        bt(root, answer, "");
        return answer;
    }

    public void bt(BSTValidator.TreeNode node, List<String> tracker, String path){
        if (node.left == null && node.right == null){
            //tracker.add(node.val);
            tracker.add(path + node.val);
            return;
        }

        if (node.left != null){
            bt(node.left, tracker, path + node.val + "->");
        }

        if (node.right != null){
            bt(node.right, tracker, path + node.val + "->");
        }
    }
}
