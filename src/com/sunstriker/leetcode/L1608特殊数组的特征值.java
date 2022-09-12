package com.sunstriker.leetcode;

import java.util.Arrays;

public class L1608特殊数组的特征值 {
    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{0,4,3,0,4}));
    }
    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int index = 0 , x = 1, n = nums.length;
        while (true){
            int leftCount = n - index ;
            if( leftCount < x) return -1;
            if(x > nums[index]){
                index++;
            }else if(leftCount > x) x++;

            else return x;

        }
    }
}
