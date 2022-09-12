package com.sunstriker.leetcode;

public class L2401最长优雅子数组 {
    public static void main(String[] args) {
        new L2401最长优雅子数组().longestNiceSubarray(new int[]{1,3,8,48,10});
    }
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0, maxLength = 1, window = 0;
        while (right < n){
            int num = nums[right++];
            while ((window & num) != 0) {
                int out = nums[left++];
                window &= ~out;
            }
            window |= num;
            if(right-left > maxLength) maxLength = right-left;
        }
        return maxLength;
    }
}
