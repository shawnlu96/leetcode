package com.sunstriker.leetcode;

import java.util.Arrays;

public class L31下一个排列 {
    public static void main(String[] args) {
        new L31下一个排列().nextPermutation(new int[]{4,2,0,2,3,2,0});
    }
    public void nextPermutation(int[] nums) {
        int topIndex = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if(nums[i]> nums[i-1]){
                topIndex = i-1;
                break;
            }
        }
        if(topIndex == -1) Arrays.sort(nums);
        else {
            int temp = nums[topIndex];
            int a = nums.length-1;
            while (nums[a] <= temp){
                a--;
            }
            nums[topIndex] = nums[a];
            nums[a] = temp;
            for (int i = topIndex + 1; i <= (topIndex + nums.length)/2; i++) {
                temp = nums[i];
                nums[i] = nums[nums.length - i + topIndex ];
                nums[nums.length - i + topIndex ] = temp;
            }
        }
    }
}
