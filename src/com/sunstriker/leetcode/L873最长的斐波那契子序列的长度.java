package com.sunstriker.leetcode;

import java.util.HashMap;

public class L873最长的斐波那契子序列的长度 {
    public int lenLongestFibSubseq(int[] arr) {
        if(arr.length< 3) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) map.put(arr[i], i);
        int[][] dp = new int[arr.length][arr.length];
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i-1; j >=0 && j+2 > res ; j--) {
                int target = arr[i] - arr[j];
                if(target >= arr[j]) break;
                if(!map.containsKey(target)) continue;
                int targetIndex = map.get(target);
                dp[i][j] = Math.max(3,dp[j][targetIndex] + 1);
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }
}
