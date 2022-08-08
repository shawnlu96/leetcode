package com.sunstriker.leetcode;

public class L115不同的子序列 {
    public static void main(String[] args) {
        System.out.println(new L115不同的子序列().numDistinct("fff", "ffff"));
    }
    public int numDistinct(String s, String t) {
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = i > 0 ? dp[i - 1] : 0;
            if (s.charAt(i) == t.charAt(0)) dp[i]++;
        }
        for (int i = 1; i < t.length(); i++) {
            int prev = dp[i - 1];
            for (int j = 0; j < i; j++) {
                dp[j] = 0;
            }
            for (int j = i; j < s.length(); j++) {
                int temp = dp[j];
                if (t.charAt(i) != s.charAt(j)) {
                    dp[j] = j == i ? 0 : dp[j - 1];
                } else {
                    dp[j] = j == i ? prev : prev + dp[j - 1];
                }
                prev = temp;
            }
        }
        return dp[s.length() - 1];
    }
}
