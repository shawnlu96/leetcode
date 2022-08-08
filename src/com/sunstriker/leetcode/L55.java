package com.sunstriker.leetcode;

public class L55 {
    public boolean canJumpDP(int[] nums){
        int[] dp = new int[nums.length];
        // dp[n] 为到达n处后的最大剩余步数
        dp[0] = nums[0];
        int index = 1;
        while(index<nums.length){
            if(dp[index-1] == 0 ) return false;
            dp[index] = Math.max(dp[index-1] -1, nums[index]);
            index ++;
        }
        return true;
    }

    public boolean canJump(int[] nums){
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if(farthest<=i) return false;
        }
        return farthest >= nums.length-1;
    }
}
