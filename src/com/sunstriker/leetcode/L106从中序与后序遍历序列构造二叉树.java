package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

public class L106从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {
        var res = new L106从中序与后序遍历序列构造二叉树().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        res.printTree();
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode helper (int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd){
        if(pEnd  - pStart < 0) return null;
        if (pEnd  - pStart == 0) return new TreeNode(postorder[pEnd]);
        int leftTreeSize = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if(inorder[i] ==  postorder[pEnd]){
                leftTreeSize = i - iStart;
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[pEnd]);
        root.left = helper(inorder, iStart, iStart + leftTreeSize -1, postorder, pStart,  pStart + leftTreeSize -1);
        root.right  = helper(inorder, iStart + leftTreeSize +1, iEnd, postorder,  pStart + leftTreeSize, pEnd -1);
        return root;
    }
}
