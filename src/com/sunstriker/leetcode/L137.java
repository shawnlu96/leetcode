package com.sunstriker.leetcode;

import java.util.Arrays;

public class L137 {
    public static void main(String[] args) {
        Class<L300> l300Class = L300.class;
        System.out.println("123".getClass().getClassLoader());
    }
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        int[] fib = new int[n+1];
        Arrays.fill(fib, 1);
        fib[0] = 0;
        for(int i=3; i<=n;i++){
            fib[i] = fib[i-1] + fib[i-2] + fib[i-3];
        }
        return fib[n];
    }
}
