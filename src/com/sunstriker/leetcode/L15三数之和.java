package com.sunstriker.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15三数之和 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{1,-1,-1,0}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int lo = i+1, hi = nums.length-1;
            while (lo < hi){
                int sum = nums[lo]+nums[hi];
                if(target > sum) lo++;
                else if (target < sum) hi--;
                else {
                    List<Integer> row = new ArrayList<>();
                    int left = nums[lo], right = nums[hi];
                    row.add(nums[i]);
                    row.add(left);
                    row.add(right);
                    res.add(row);
                    while (lo < hi && nums[lo] == left) lo ++;
                    while (lo < hi && nums[hi] == right) hi --;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }


}
