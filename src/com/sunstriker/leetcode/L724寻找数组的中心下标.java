package com.sunstriker.leetcode;

import java.util.Arrays;

public class L724寻找数组的中心下标 {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0, rightSum = sum-nums[0];
        if(leftSum == rightSum) return 0;
        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i-1];
            rightSum-= nums[i];
            if(leftSum==rightSum) return i;
        }
        return -1;
    }
}
