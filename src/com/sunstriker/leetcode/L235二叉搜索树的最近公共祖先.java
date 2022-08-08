package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

public class L235二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val1 = Math.min(p.val, q.val), val2 = Math.max(p.val, q.val);
        return finder(root, val1, val2);
    }

    public TreeNode finder(TreeNode root, int lower, int greater){
        if(root == null) return null;
        if(root.val > greater){
            return finder(root.left, lower, greater);
        }
        if(root.val < lower){
            return finder(root.right, lower, greater);
        }
        return root;
    }
}
