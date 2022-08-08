package com.sunstriker.jzoffer;

import com.sunstriker.structure.TreeNode;

public class JZ79IsBalancedTree {
    boolean isBalance = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        TreeDepth(root);
        return isBalance;
    }

    public int TreeDepth (TreeNode root){
        if(root == null) return 0;
        int l = TreeDepth(root.left);
        int r = TreeDepth(root.right);
        if(Math.abs(l-r)>1) {
            isBalance = false;
            return -1;
        }
        return Math.max(l,r) + 1;
    }
}
