package com.sunstriker.leetcode;

import java.util.Arrays;

public class L72编辑距离 {
    int[][] memo;

    public int minDistance1(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        memo = new int[m][n];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dp(word1, word2, m - 1, n - 1);
    }

    public int dp(String s1, String s2, int i, int j) {
        int res;
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;
        if (memo[i][j] != -1) return memo[i][j];
        if (s1.charAt(i) == s2.charAt(j)) return dp(s1, s2, i - 1, j - 1);
        res = Math.min(
                dp(s1, s2, i - 1, j - 1) + 1, // 替换
                Math.min(
                        dp(s1, s2, i - 1, j) + 1,// 删除
                        dp(s1, s2, i, j - 1) + 1 // 添加
                )
        );
        return memo[i][j] = res;
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                dp[i][j] = Math.min(
                        dp[i - 1][j - 1] + 1,       // 替换
                        Math.min(dp[i - 1][j] + 1,  // 添加
                                dp[i][j - 1] + 1)   // 删除
                );
            }
        }
        return dp[m][n];
    }
}
