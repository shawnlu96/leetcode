package com.sunstriker.leetcode;

public class L2400恰好移动k步到达某一位置的方法数目 {
    public static void main(String[] args) {
        System.out.println(numberOfWays(1,10,3));
    }

    static int MOD = (int) Math.pow(10, 9) + 7;

    public static int numberOfWays(int startPos, int endPos, int k) {
        int distance = Math.abs(endPos - startPos);
        int n = distance + k;
        int[] dp = new int[n];
        for (int i = 0; i <=k; i++) {
            int temp = dp[i];
            dp[i] = 1;
            for (int j = i-1; j >=0 ; j--) {
                int res = (temp + (j==0?temp:dp[j-1])) % MOD;
                temp = dp[j];
                dp[j] = res;
            }
        }
        return dp[distance];

    }


}
