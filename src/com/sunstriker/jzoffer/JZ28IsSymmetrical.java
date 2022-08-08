package com.sunstriker.jzoffer;

import com.sunstriker.structure.TreeNode;

public class JZ28IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot ==null)return true;
        return isSymmetrical(pRoot.left,pRoot.right);
    }
    boolean isSymmetrical(TreeNode root1, TreeNode root2){
        if(root1==null || root2 == null) return root1 == null && root2 == null;
        return root1.val== root2.val && isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right,root2.left);
    }

}
