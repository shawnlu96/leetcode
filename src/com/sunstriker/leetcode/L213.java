package com.sunstriker.leetcode;

public class L213 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new L213().rob(nums));
        ;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robRange(nums, 1, nums.length - 1), robRange(nums, 0, nums.length - 2));
    }

    public int robRange(int[] nums, int start, int end) {
        if (end - start == 0) return nums[start];
        if (end - start == 1) return Math.max(nums[start], nums[end]);

        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start +1]);

        for (int i = 2; i < end - start + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }

        return dp[dp.length-1];
    }
}
