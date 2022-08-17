package com.sunstriker.leetcode;

import java.util.Arrays;

public class L1143最长公共子序列 {
    public static void main(String[] args) {
        System.out.println(new L1143最长公共子序列().longestCommonSubsequence("abcde", "ace"));
    }

    // 空间压缩
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] dp = new int[n + 1];
        int[] temp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[j] = temp[j-1] + 1;
                else dp[j] = Math.max(temp[j], dp[j-1]);
            }
            temp = Arrays.copyOf(dp, n+1);
        }
        return dp[n];
    }

    public int longestCommonSubsequenceOriginal(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
