package com.sunstriker.leetcode;

public class L518零钱兑换II {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 1; i <=n ; i++) {
            int coin = coins[i-1];
            for (int j = coin; j <=amount ; j++) {
                dp[i] += dp[j-coin];
            }

        }
        return dp[amount];
    }

    public int changeOriginal(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for (int i = 1; i <=n ; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <=n ; i++) {
            int coin = coins[i-1];
            for (int j = 1; j <=amount ; j++) {
                if(j<coin) dp[i][j] = dp[i-1][j];
                else dp[i][j] =dp[i-1][j] + dp[i][j-coin];
            }
        }
        return dp[n][amount];
    }
}
