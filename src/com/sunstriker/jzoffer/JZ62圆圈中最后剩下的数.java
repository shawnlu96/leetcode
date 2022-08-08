package com.sunstriker.jzoffer;

public class JZ62圆圈中最后剩下的数 {
    public int LastRemaining_Solution(int n, int m) {
        int pos = 0;
        for (int i = 2; i <= n; i++) {
            pos = (pos +m)% i;
        }
        return pos + 1;
    }
}
