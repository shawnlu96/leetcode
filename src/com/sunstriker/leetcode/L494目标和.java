package com.sunstriker.leetcode;

public class L494目标和 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0, max = 0, n = nums.length;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if((sum + Math.abs(target) ) % 2 == 1) return 0;
        int t = (sum +  Math.abs(target)) / 2;
        if(max>t) return 0;
        int[] dp =new int[t+1];
        dp[0] = 1;
        for (int i = 1; i <=n ; i++) {
            int  num = nums[i-1];
            for (int j = t; j >= num ; j--) {
                dp[j] += dp[j-num];
            }
        }
        return dp[t];
    }
}
