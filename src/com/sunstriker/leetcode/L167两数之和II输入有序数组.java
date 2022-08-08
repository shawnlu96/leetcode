package com.sunstriker.leetcode;

public class L167两数之和II输入有序数组 {
    // 必须只使用常量级的额外空间
    public int[] twoSum(int[] numbers, int target) {
        int left = 0 , right = numbers.length-1;
        while (left< right){
            int sum = numbers[left] + numbers[right];
            if(sum == target) return new int[]{left, right};
            else if (sum < target) left++;
            else right--;
        }
        return null;
    }
}
