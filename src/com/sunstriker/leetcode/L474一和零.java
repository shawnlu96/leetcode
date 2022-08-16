package com.sunstriker.leetcode;

public class L474一和零 {
    public static void main(String[] args) {
        System.out.println(new L474一和零().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= l; i++) {
            int zeros = 0, ones = 0;
            String str = strs[i-1];
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') zeros++;
                else ones++;
            }
            for (int j = m; j >=zeros ; j--) {
                for (int k = n; k >= ones ; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-zeros][k-ones]+1);
                }
            }

        }
        return dp[m][n];
    }
}
