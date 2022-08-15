package com.sunstriker.leetcode;

public class L322零钱兑换 {
    public static void main(String[] args) {
        System.out.println(new L322零钱兑换().coinChange(new int[]{186,419,83,408}, 6249));
    }



    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return -1;
        Integer[] dp = new Integer[amount + 1];
        for (int coin : coins) {
            if (coin <= amount) dp[coin] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] != null && dp[i] == 1) continue;
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int last = i - coin;
                if (last < 0) continue;
                if (dp[last] == null || dp[last] == -1) continue;
                min = Math.min(min, dp[last] + 1);
            }
            if (min == Integer.MAX_VALUE) min = -1;
            dp[i] = min;
        }
        return dp[amount];
    }


}
