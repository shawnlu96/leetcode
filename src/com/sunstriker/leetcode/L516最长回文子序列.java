package com.sunstriker.leetcode;

public class L516最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = n-1; i >= 0; i--) {
            dp[i] = 1;
            int lastLeft = 0;
            int temp;
            for (int j = i+1; j < n; j++) {
                temp = dp[j];
                if(s.charAt(i) == s.charAt(j)) dp[j] = lastLeft+2;
                else dp[j] = Math.max(dp[j], dp[j-1]);
                lastLeft = temp;
            }
        }
        return dp[n-1];
    }

    public int longestPalindromeSubseqOriginal(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;

        }
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1]+2;
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}
