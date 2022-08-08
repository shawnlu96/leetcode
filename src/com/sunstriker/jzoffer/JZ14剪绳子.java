package com.sunstriker.jzoffer;

public class JZ14剪绳子 {
    public int cutRope (int n) {
        // write code here
        if(n == 2) return 1;
        if(n == 3) return 2;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for (int i = 5; i <=n ; i++) {
            int half = i/2;
            dp[i] = Math.max(dp[half] * dp[i-half], dp[half-1] *  dp[i-half+1]);
        }
        return dp[n];
    }
}
