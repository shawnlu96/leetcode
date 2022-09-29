package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L560和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) res++;
            int target = sum - k;
            res += map.getOrDefault(target, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
