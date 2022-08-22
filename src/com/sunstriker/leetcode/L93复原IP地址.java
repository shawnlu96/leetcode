package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L93复原IP地址 {
    public static void main(String[] args) {
        var a = "101023";
        System.out.println(new L93复原IP地址().restoreIpAddresses(a));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack("", s, 4, res);
        return res;
    }

    void backtrack(String curr, String left,int digitLeft, List<String> res ){
//        System.out.printf("curr: %s, left:%s, digitLeft:%d\n", curr, left, digitLeft);
        if(digitLeft == 0) {
            if(left.length() == 0) res.add(curr.substring(0, curr.length()-1));
            return;
        }
        int n = left.length();
        if(n==0) return;
        if(n > digitLeft * 3) return;
        int i = 1;
        if(n == digitLeft * 3) i = 3;
        if(left.charAt(0) == '0') n = 1;
        for (; i <= 3 && i <= n; i++) {
            String candidate = left.substring(0, i);
            int candidateInt = Integer.parseInt(candidate);
            if(candidateInt > 255) break;
            backtrack(curr +candidate + '.', left.substring(i), digitLeft-1, res);
        }
    }
}
