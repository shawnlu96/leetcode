package com.sunstriker.leetcode;

import com.sunstriker.structure.TreeNode;

public class L654最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if(start > end) return null;
        if(start == end) return new TreeNode(nums[start]);
        int maxIndex = getMaxIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = helper(nums, start, maxIndex-1);
        root.right = helper(nums, maxIndex+1,  end);
        return root;
    }

    private int getMaxIndex(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (; start <= end; start++) {
            if (max < nums[start]) {
                max = nums[start];
                maxIndex = start;
            }
        }
        return maxIndex;
    }
}
