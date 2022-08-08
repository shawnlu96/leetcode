package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L96不同的二叉搜索树 {
    int[][] memo;
    public int numTrees(int n) {
        memo  = new int[n+1][n+1];
        return count(1, n);
    }

    public int count(int lo, int hi){
        if(lo > hi) return 1;
        int res = 0;
        if(memo[lo][hi] != 0) return memo[lo][hi];
        for (int i = lo; i <= hi; i++) {
            int left = count(lo, i-1);
            int right = count(i+1, hi);
            res += left * right;
        }
        memo[lo][hi] = res;
        return res;
    }

    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    public List<TreeNode> build(int lo, int hi){
        List<TreeNode> res = new ArrayList<>();
        if(lo > hi){
            res.add(null);
            return res;
        }
        for (int i = lo; i <=hi ; i++) {
            List<TreeNode> leftTrees = build(lo, i-1);
            List<TreeNode> rightTrees = build(i+1, hi);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
