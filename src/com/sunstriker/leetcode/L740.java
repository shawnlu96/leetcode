package com.sunstriker.leetcode;

public class L740 {
    public int deleteAndEarn(int[] nums) {

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if(num>max) max = num;
            if(num< min) min = num;
        }

        int[] points = new int[max-min + 1];
        for (int num : nums) {
            points[num] += num;
        }

        int[] dp = new int[max-min + 1];
        if(points.length==1) return points[0];
        dp[0] = points[0];
        dp[1] = Math.max(points[0], points[1]);
        for (int i = 2; i < dp.length ; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + points[i] );
        }
        return dp[dp.length-1];
    }
}
