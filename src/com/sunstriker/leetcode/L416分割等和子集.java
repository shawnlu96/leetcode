package com.sunstriker.leetcode;

public class L416分割等和子集 {

    public boolean canPartition(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        if (nums.length < 2) return false;
        for (int num : nums) {
            sum += num;
            max = Math.max(num, max);

        }
        int targetSum = sum / 2;
        if (sum % 2 != 0 || max > targetSum) return false;
        return canSum(nums, targetSum);
    }

    public boolean canSum(int[] nums, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            for (int j = dp.length - 1; j >= num; j--) {
                dp[j] |=  dp[j - num];
            }

        }
        return dp[target];
    }
}
