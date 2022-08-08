package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

import java.util.Stack;

public class L100相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(p);
        s2.push(q);
        while (!s1.isEmpty()){
            TreeNode r1 = s1.pop();
            TreeNode r2 = s2.pop();
            if(r1 == null){
                if(r2 != null) return false;
            }else {
                if(r2 == null) return false;
                if(r1.val != r2.val) return false;
                s1.push(r1.left);
                s2.push(r2.left);
                s1.push(r1.right);
                s2.push(r2.right);
            }
        }
        return true;
    }
}
