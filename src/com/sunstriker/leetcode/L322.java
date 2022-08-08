package com.sunstriker.leetcode;

import java.util.Arrays;

public class L322 {

    public static void main(String[] args) {
	// write your code here
        var res = coinChange(new int[]{1,2,5}, 11);

    }

    public static int coinChange(int[] coins, int amount) {
        if(amount ==0) return 0;
        if (amount<0) return  -1;

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if(coin > i) continue;
                if(coin == i) {
                    dp[i] = 1;
                    break;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i-coin]);

            }
        }

        return (dp[amount] == amount+1)?-1 : dp[amount];
    }
}
