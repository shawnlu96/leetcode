package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

public class L104二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
    }

}
