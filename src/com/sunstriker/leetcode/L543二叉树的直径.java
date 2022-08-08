package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

public class L543二叉树的直径 {
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    public int maxDepth(TreeNode node) {
        if (node == null) return 0;
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        int diameter = left+right;
        maxDiameter = Math.max(diameter, maxDiameter);
        return 1 + Math.max(left,right);
    }
}
