package com.sunstriker.leetcode;

import java.util.Arrays;

public class L1652拆炸弹 {
    // 简单模拟
    public static int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if(k == 0){
            return res;
        }else if(k > 0){
            for(int i = 1; i <= k; k++){
                res[0] += get(code, i);
            }
            for(int i = 1; i < code.length;i++){
                res[i] = res[i-1] - get(code, i) + get(code, i+k);
            }
        }else{
            for(int i = k; i < 0; i++){
                res[0] += get(code, i);
            }
            for(int i = 1; i < code.length;i++){
                res[i] = res[i-1] + get(code, i-1) - get(code, i-1+k);
            }
        }
        return res;

    }

    public static int get(int[] code, int id){
        int n = code.length;
        if(id < 0) id += n;
        else if(id >= n ) id -= n;
        return code[id];
    }
}
