package com.sunstriker.leetcode;

import java.util.HashSet;
import java.util.Set;

public class L2395和相等的子数组 {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i] + nums[i-1];
            if(set.contains(sum)) return true;
            else set.add(sum);
        }
        return false;
    }
}
