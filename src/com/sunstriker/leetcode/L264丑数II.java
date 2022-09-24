package com.sunstriker.leetcode;

public class L264丑数II {
    // 其实可以理解为链表的合并
    public int nthUglyNumber(int n) {
        int[] indices = new int[3];
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = Math.min(res[indices[0] ]*2, Math.min(res[indices[1]] * 3,res[indices[2]] * 5));
            if(res[i] ==res[indices[0]] * 2) indices[0]++;
            if(res[i] ==res[indices[1]] * 3) indices[1]++;
            if(res[i] ==res[indices[2]] * 5) indices[2]++;
        }
        return res[n-1];
    }
}
