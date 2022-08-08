package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

public class L124二叉树中的最大路径和 {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        maxSum(root);
        return res;
    }

    public int maxSum(TreeNode root){
        if(root == null) return 0;
        int leftSum =Math.max(0,maxSum(root.left));
        int rightSum = Math.max(0,maxSum(root.right));
        int maxPathSum = root.val + leftSum + rightSum;
        res = Math.max(res, maxPathSum);
        return Math.max(leftSum,rightSum) + root.val;
    }
}
