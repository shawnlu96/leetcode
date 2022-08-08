package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

import java.util.Arrays;

public class L105从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        var as = new L105从前序与中序遍历序列构造二叉树().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        as.printTree();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preEnd - preStart < 0) return null;
        if(preEnd == preStart) return new TreeNode(preorder[preStart]);
        int rootNum = preorder[preStart];
        int leftTreeSize = - 1;
        while (++leftTreeSize <= preEnd - preStart) {
            if (rootNum == inorder[inStart + leftTreeSize]) break;
        }
        TreeNode root = new TreeNode(rootNum);
        root.left = buildTree(preorder, inorder, preStart + 1, preStart + leftTreeSize, inStart, inStart + leftTreeSize - 1);
        root.right = buildTree(preorder, inorder, preStart + leftTreeSize + 1, preEnd,  inStart+ leftTreeSize + 1, inEnd);
        return root;
    }

}
