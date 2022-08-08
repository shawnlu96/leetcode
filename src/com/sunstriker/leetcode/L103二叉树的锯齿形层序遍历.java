package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class L103二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        stack.push(root);
        boolean desc = false;
        while (!stack.isEmpty()) {
            desc = !desc;
            LinkedList<TreeNode> list = new LinkedList<>();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                list.add(stack.pop());
            }
            for (TreeNode treeNode : list) {
                if(desc){
                    if(treeNode.left!=null) stack.push(treeNode.left);
                    if(treeNode.right!=null) stack.push(treeNode.right);
                }else{
                    if(treeNode.right!=null) stack.push(treeNode.right);
                    if(treeNode.left!=null) stack.push(treeNode.left);
                }
            }

            res.add(list.stream().map(n -> n.val).collect(Collectors.toList()));
        }
        return res;
    }
}
