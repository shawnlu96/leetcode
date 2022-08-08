package com.sunstriker.leetcode;

public class L29两数相除 {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE/2);
        System.out.println(new L29两数相除().divide(766,766));
    }
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        boolean positive = true;
        // 由于Integer.MIN_VALUE求绝对值会溢出Integer范围，所以需要特殊考虑
        if(dividend == Integer.MIN_VALUE) {
            if(divisor == -1) return Integer.MAX_VALUE;
            if(divisor == Integer.MIN_VALUE) return 1;
        }
        if(divisor == 1) return dividend;
        if(divisor == -1) return ~dividend + 1;
        if((dividend^divisor) < 0) positive = false;
        int res = 0;
        int maxLeftOffset = 0;
        // 找到divisor最大可左移的量
        while ((Math.abs(divisor)  << maxLeftOffset) >0) {
            maxLeftOffset ++ ;
        }
        for (int i = --maxLeftOffset; i >=0 ; i--) {
            int subtractor = divisor << i;
            // 若除完，则直接跳出循环
            if(dividend == 0) break;
            // 算出此次+/-后的预计剩余结果
            int rest = dividend - (positive ? subtractor : -subtractor);
            // 这里根据符号考虑两种情况，其实就是排除掉剩余dividend不够subtractor减去的情况
            if(dividend > 0 && rest < 0) continue;
            if(dividend < 0 && rest > 0) continue;
            // 若相等则代表答案是2个subtractor，即1<<(i+1)
            if(Math.abs(rest) == Math.abs(subtractor)){
                res += 1 << (i+1);
            }
            if(Math.abs(rest) < Math.abs(subtractor)) {
                dividend = rest;
                res += 1 << i;
            }
        }
        // 根据符号不同计算
        return positive ? res : -res;
    }
}
