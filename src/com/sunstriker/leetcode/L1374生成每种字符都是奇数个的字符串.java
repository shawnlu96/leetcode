package com.sunstriker.leetcode;

import java.util.Arrays;

public class L1374生成每种字符都是奇数个的字符串 {
    public String generateTheString(int n) {
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');
        if(n%2!=1) arr[n-1] = 'b';
        return String.copyValueOf(arr);
    }
}
