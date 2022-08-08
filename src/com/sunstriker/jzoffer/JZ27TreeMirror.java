package com.sunstriker.jzoffer;

import com.sunstriker.structure.TreeNode;

public class JZ27TreeMirror {
    public TreeNode Mirror(TreeNode pRoot) {
        // write code here
        TreeNode temp;
        if (pRoot == null || (pRoot.left == null && pRoot.right == null)) return pRoot;
        temp = pRoot.left;
        pRoot.left = Mirror(pRoot.right);
        pRoot.right = Mirror(temp);
        return pRoot;
    }
}
