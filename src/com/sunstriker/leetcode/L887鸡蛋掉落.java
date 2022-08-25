package com.sunstriker.leetcode;

public class L887鸡蛋掉落 {
    public static void main(String[] args) {
        System.out.println(new L887鸡蛋掉落().superEggDrop(13, 8192));
    }
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        for (int i = 1; i <=n ; i++) {
            dp[1][i] = i;
        }
        for (int i = 1; i <=k ; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <=n ; j++) {
                int left = 1, right = j;
                while (left+1 < right) {
                    int mid = left + (right-left) / 2;
                    int ascendingRes = dp[i-1][mid-1];
                    int descendingRes = dp[i][j-mid];
                    if(ascendingRes < descendingRes){
                        left = mid;
                    }else if(ascendingRes > descendingRes){
                        right = mid;
                    }else {
                        left = right = mid;
                    }
                }
                dp[i][j] =1+ Math.min(Math.max(dp[i-1][left-1], dp[i][j-left]),Math.max(dp[i-1][right-1], dp[i][j-right]) );
//                int res = Integer.MAX_VALUE;
//                // 第一个鸡蛋可以在1~j的任意一层扔
//                for (int l = 1; l <= j; l++) {
//                    int temp = 1 + Math.max(dp[i-1][l-1], dp[i][j-l]);
//                    res = Math.min(temp, res);
//                }
//                dp[i][j] = res;
            }
        }
        return dp[k][n];
    }
}
