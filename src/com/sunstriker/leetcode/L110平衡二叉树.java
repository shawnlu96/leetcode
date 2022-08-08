package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

public class L110平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode node){
        if(node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
