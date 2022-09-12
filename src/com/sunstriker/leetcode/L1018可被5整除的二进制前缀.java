package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1018可被5整除的二进制前缀 {
    public static void main(String[] args) {
        System.out.println(new L1018可被5整除的二进制前缀().prefixesDivBy5(new int[]{0, 1, 1}));
    }

    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = 0;
        List<Boolean> res = new ArrayList<>();
        for (int num : nums) {
            res.add((n = ((n << 1) + num) % 5) == 0);
        }
        return res;
    }
}
