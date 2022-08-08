package com.sunstriker.jzoffer;

public class JZ47礼物的最大价值 {
    public int maxValue (int[][] grid) {
        // write code here
        int[][] dp = new int[grid.length+1][grid[0].length +1];
//        for (int i = 0; i < dp[0].length; i++) {
//            dp[dp.length-1][i] = 0;
//        }
//        for (int i = 0; i < dp.length; i++) {
//            dp[i][dp[0].length-1] = 0;
//        }
        int x = grid.length-1, y = grid[0].length-1;
        while (dp[0][0]==0){
            for (int i = x; i >=0 ; i--) {
                dp[i][y] = grid[i][y] + Math.max(dp[i+1][y], dp[i][y+1]);
            }
            for (int i = y; i >=0 ; i--) {
                dp[x][i] = grid[x][i] + Math.max(dp[x+1][i], dp[x][i+1]);
            }
            if(x>0)x--;
            if(y>0)y--;
        }
        return dp[0][0];
    }
}
