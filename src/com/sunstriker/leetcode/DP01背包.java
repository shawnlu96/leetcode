package com.sunstriker.leetcode;

/**
 * 给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你用这个背包装物品，最多能装的价值是多少?
 */
public class DP01背包 {

    public int knapsack(int W, int N, int[] wt, int[] val) {
        // 对于前i个物品，当背包容量为j时， 可以装的最大价值为dp[i][j]
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            int currentWeight = wt[i-1];
            int currentValue = val[i-1];
            for (int j = 1; j <= W; j++) {
                if (currentWeight > j) {
                    // 若物品容量大于当前容量
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j -currentWeight] + currentValue
                    );
                }
            }
        }
        return dp[N][W];
    }
}
