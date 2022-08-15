package com.sunstriker.leetcode;

public class L300最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int num = nums[i];
            int currMax = 1;
            for (int j = 0; j <= i; j++) {
                if(num > nums[j]) currMax = Math.max(dp[j]+1, currMax);
            }
            res = Math.max(currMax, res);
            dp[i] = currMax;
        }
        return res;
    }
}
