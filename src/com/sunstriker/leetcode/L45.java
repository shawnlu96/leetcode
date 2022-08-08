package com.sunstriker.leetcode;

public class L45 {
    public int jumpDP(int[] nums) {
        if(nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < nums.length; i++) {
            int minJump = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                int neededDistance = i - j; 
                if(neededDistance <=nums[j]) minJump = Math.min(minJump, dp[j] + 1);
            }
            dp[i] = minJump;
        }

        return dp[nums.length-1];
    }

    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int  end = 0, farthest = 0;
        int jump = 0;
        for (int i = 0; i < nums.length-1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if(i == end){
                end = farthest;
                jump ++;
            }
        }
        return jump;
    }
}
