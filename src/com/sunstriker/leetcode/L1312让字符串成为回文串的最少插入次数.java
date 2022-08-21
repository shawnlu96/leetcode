package com.sunstriker.leetcode;

public class L1312让字符串成为回文串的最少插入次数 {
    public int minInsertions(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = n-1; i >=0 ; i--) {
            int lastLeft = 0;
            int temp;
            for (int j = i+1; j < n ; j++) {
                temp = dp[j];
                if(s.charAt(i) == s.charAt(j)) dp[j] = lastLeft;
                else dp[j] = Math.min(dp[j], dp[j-1])+1;
                lastLeft = temp;
            }
        }
        return dp[n-1];
    }

    public int minInsertionsOriginal(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n-1; i >=0 ; i--) {
            for (int j = i+1; j < n ; j++) {
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1];
                else dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1])+1;
            }
        }
        return dp[0][n-1];
    }
}
