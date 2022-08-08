package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

public class L101对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    public boolean helper (TreeNode n1, TreeNode n2){
        if(n1 == null){
            return n2 == null;
        }else {
            if(n2 == null || n2.val != n1.val) return false;
            return helper(n1.right, n2.left) && helper(n1.left, n2.right);
        }
    }
}
