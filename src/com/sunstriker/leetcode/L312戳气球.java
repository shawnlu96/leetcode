package com.sunstriker.leetcode;

public class L312戳气球 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n+2];
        balloons[0] = balloons[n+1] = 1;
        System.arraycopy(nums, 0, balloons, 1, n);
        // dp[i][j]表示(i,j)中气球戳破的最大值
        int[][] dp = new int[n+2][n+2];
        for (int i = n+1; i >=0 ; i--) {
            for (int j = i+1; j < n+2; j++) {
                for (int k = i+1; k < j ; k++) {
                    dp[i][j] = Math.max(
                            dp[i][j],
                            dp[i][k] + dp[k][j] + balloons[i] * balloons[k] * balloons[j]
                            );
                }
            }
        }   
        return dp[0][n+1];
    }
}
