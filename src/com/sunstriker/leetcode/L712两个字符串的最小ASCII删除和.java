package com.sunstriker.leetcode;

public class L712两个字符串的最小ASCII删除和 {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[] dp = new int[n+1];
        int[] temp = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            temp[i] = temp[i-1] + s2.charAt(i-1);
        }
        for (int i = 1; i <=m ; i++) {
            dp[0] += s1.charAt(i-1);
            for (int j = 1; j <=n ; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[j] = temp[j-1];
                else dp[j] = Math.min(dp[j-1] + s2.charAt(j-1), temp[j] + s1.charAt(i-1));
            }
            int[] s = temp;
            temp = dp;
            dp = s;
        }
        return dp[n];
    }
}
