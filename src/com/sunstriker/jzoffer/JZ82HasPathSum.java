package com.sunstriker.jzoffer;

import com.sunstriker.structure.TreeNode;

public class JZ82HasPathSum {
    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if(root == null ) return false;
        if(root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum- root.val) || hasPathSum(root.right, sum- root.val);
    }
}
