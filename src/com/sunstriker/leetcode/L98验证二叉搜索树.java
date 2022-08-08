package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

import java.util.Stack;

public class L98验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    private boolean helper (TreeNode root, long max, long min)  {
        if(root.val>= max || root.val<=min) return false;
        if(root.left != null){
            if(root.left.val >= root.val) return false;
            if(!helper(root.left, root.val, min)) return false;
        }
        if(root.right != null){
            if(root.right.val <= root.val) return false;
            if(!helper(root.right, max, root.val)) return false;
        }
        return true;
    }

    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer num = null;
        TreeNode  curr = root;
        while (curr!= null || !stack.isEmpty()){
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(num != null && curr.val <= num) return false;
            num = curr.val;
            curr = curr.right;
        }
        return true;
    }
}
