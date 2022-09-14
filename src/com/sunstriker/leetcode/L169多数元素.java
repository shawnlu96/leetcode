package com.sunstriker.leetcode;

public class L169多数元素 {
    public int majorityElement(int[] nums) {
        int target = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                target = num;
                count++;
            } else if (target == num) count++;
            else if (target != num) count--;
        }
        return target;
    }
}
