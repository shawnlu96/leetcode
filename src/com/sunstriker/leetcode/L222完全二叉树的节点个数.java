package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

public class L222完全二叉树的节点个数 {
    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        int lh = 0, rh = 0;
        while (l!=null){
            l = l.left;
            lh++;
        }
        while (r!=null){
            r = r.right;
            rh++;
        }
        if(lh == rh) return (int)Math.pow(2,lh)  -1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
