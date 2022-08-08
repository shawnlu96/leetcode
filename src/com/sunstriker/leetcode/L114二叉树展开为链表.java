package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class L114二叉树展开为链表 {
    public static void main(String[] args) {
        var root = TreeNode.generateByRow(new Integer[]{1,2,null,3});
        root.printTree();
        new L114二叉树展开为链表().flattenInPlace(root);
        root.printTree();
    }
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode dummy = new TreeNode();
        TreeNode curr = dummy;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
            curr.left = null;
            curr.right = node;
            curr = curr.right;
        }
    }

    /**
     *
     * @param root
     * @return 展开后的最后一个节点
     */
    public TreeNode flattenInPlace(TreeNode root){
        if(root == null) return null;
        if(root.left == null && root.right==null) return root;
        TreeNode leftEnd = flattenInPlace(root.left);
        TreeNode rightEnd =  flattenInPlace(root.right);
        TreeNode  leftHead = root.left;
        TreeNode rightHead = root.right;
        if(leftHead!=null) {
            root.left = null;
            root.right = leftHead;
            leftEnd.right = rightHead;
        }
        return rightEnd == null ? leftEnd : rightEnd;

    }

}
