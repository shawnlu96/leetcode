package com.sunstriker.leetcode;

public class L59螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        int max = n * n, curr = 1;
        int[][] res = new int[n][n];
        int left = 0, up = 0, down = n-1, right = n-1;
        int direction = 0;
        while (curr <= max){
            switch (direction % 4) {
                case 0 -> {
                    for (int i = left; i <= right; i++) {
                        res[up][i] = curr++;
                    }
                    up++;
                }
                case 1 -> {
                    for (int i = up; i <= down; i++) {
                        res[i][right] = curr++;
                    }
                    right--;
                }
                case 2 -> {
                    for (int i = right; i >= left; i--) {
                        res[down][i] = curr ++;
                    }
                    down--;
                }
                case 3 -> {
                    for (int i = down; i >= up; i--) {
                        res[i][left] = curr ++;
                    }
                    left++;
                }
            }
            direction++;
        }
        return res;
    }
}
