package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L112_113路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();
        Deque<Integer> stack = new LinkedList<>();
        helper(root,  targetSum, stack, res);
        return res;
    }

    private void helper(TreeNode root, int targetSum, Deque<Integer> stack, List<List<Integer>> res) {
        if (root == null) return;
        stack.offerLast(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                List<Integer> ans =  new LinkedList<>(stack);
                Collections.reverse(ans);
                res.add(ans);
            }
        } else {
            helper(root.left, targetSum - root.val, stack, res);
            helper(root.right, targetSum - root.val, stack, res);
        }
        stack.pollLast();
    }


}
