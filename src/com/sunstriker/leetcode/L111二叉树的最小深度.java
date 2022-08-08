package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

public class L111二叉树的最小深度 {
    int minDepth = -1 ;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return helper(root, 0);
    }

    public int helper(TreeNode root, int currentDepth) {
        if(root.left == null && root.right == null) return currentDepth;
        int min = Integer.MAX_VALUE;
        if(root.left != null) min = helper(root.left, 1+ currentDepth);
        if(root.right!= null) min = Math.min(min, helper(root.right, 1+ currentDepth));
        return min;
    }
}
