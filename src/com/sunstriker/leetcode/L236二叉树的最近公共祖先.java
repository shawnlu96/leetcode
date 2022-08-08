package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

public class L236二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return finder(root, p.val, q.val);
    }

    TreeNode finder(TreeNode root, int val1, int val2){
        if(root == null) return null;
        if(root.val == val1 || root.val == val2) return root;
        TreeNode left = finder(root.left, val1, val2);
        TreeNode right = finder(root.right, val1, val2);
        if(left!=null & right!=null)return root;
        return left == null ? right : left;
    }
}
