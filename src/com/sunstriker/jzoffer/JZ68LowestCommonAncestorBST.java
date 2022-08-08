package com.sunstriker.jzoffer;

import com.sunstriker.structure.TreeNode;

public class JZ68LowestCommonAncestorBST {
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        // write code here
        int hi = Math.max(p, q);
        int lo = Math.min(p, q);
        if((root.val<hi && root.val > lo) || root.val == hi) return root.val;

        if(root.val<lo) return lowestCommonAncestor(root.right, p,q);
        if(root.val>hi) return lowestCommonAncestor(root.left, p,q);
        return 0;
    }
}
