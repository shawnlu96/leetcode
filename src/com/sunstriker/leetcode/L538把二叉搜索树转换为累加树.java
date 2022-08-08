package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

public class L538把二叉搜索树转换为累加树 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.right);
        root.val = sum += root.val;
        traverse(root.left);
    }
}
