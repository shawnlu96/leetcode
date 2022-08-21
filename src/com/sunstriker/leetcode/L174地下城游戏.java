package com.sunstriker.leetcode;

public class L174地下城游戏 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] dp = new int[n];
        dp[n - 1] = 1 - (Math.min(dungeon[m - 1][n - 1], 0));

        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(1, dp[i + 1] - dungeon[m - 1][i]);
        }
        for (int i = m - 2; i >= 0; i--) {
            dp[n - 1] = Math.max(1, dp[n - 1] - dungeon[i][n - 1]);
            for (int j = n - 2; j >= 0; j--) {
                dp[j] =Math.max(1,  Math.min(dp[j], dp[j+1]) - dungeon[i][j]);
            }
        }
        return dp[0];
    }

    public int calculateMinimumHPOrignal(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        // dp[i][j] = 从dungeion[i][j]房间到终点需要多少初始血量
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1 - (Math.min(dungeon[m - 1][n - 1], 0));
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = Math.max(1, dp[m - 1][i + 1] - dungeon[m - 1][i]);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] =Math.max(1,  Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
