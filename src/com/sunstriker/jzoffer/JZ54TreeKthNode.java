package com.sunstriker.jzoffer;

import com.sunstriker.structure.TreeNode;

import java.util.Stack;

public class JZ54TreeKthNode {
    public static void main(String[] args) {
        var root = TreeNode.generateByRow(new Integer[]{8,6,10,5,7,9,11});
        KthNode(root, 5);
    }

    public static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        while (pRoot != null || !stack.isEmpty()) {
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            TreeNode node = stack.pop();
            if (k == 1) return node;
            k--;
            pRoot = node.right;
        }
        return null;
    }
}
