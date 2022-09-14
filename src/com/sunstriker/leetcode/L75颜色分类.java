package com.sunstriker.leetcode;

import java.util.Arrays;

public class L75颜色分类 {
    public static void main(String[] args) {
        new L75颜色分类().sortColors(new int[]{2,0,2,1,1,0});
    }
    public void sortColors(int[] nums) {
        int id0 = 0, id2 = nums.length-1, i=0;
        while (i < id2){
            if(nums[i]==0) swap(nums, i++, id0++);
            else if(nums[i]==2)swap(nums,i,id2--);
            else i++;
        }
    }

    void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
