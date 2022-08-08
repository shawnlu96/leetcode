package com.sunstriker.jzoffer;

public class JZ13机器人的运动范围 {
    public static void main(String[] args) {
        var o = new JZ13机器人的运动范围();
        System.out.println(o.movingCount(10,1,100));
    }
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] isVisited = new boolean[rows][cols];
        return dfs(isVisited, 0,0, threshold);
    }

    public int dfs(boolean[][] isVisited, int i, int j, int threshold){
        if(i<0 || i >= isVisited.length || j<0 || j>= isVisited[0].length || isVisited[i][j]) return 0;
        isVisited[i][j] = true;
        if(digitSum(i) + digitSum(j) > threshold) {
            return 0;
        }else {
            return 1+ dfs(isVisited, i+1, j, threshold)
                    + dfs(isVisited, i-1, j, threshold)
                    + dfs(isVisited, i, j+1, threshold)
                    + dfs(isVisited, i, j-1, threshold);
        }
    }

    public int digitSum(int num){
        int  sum = 0;
        while (num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
