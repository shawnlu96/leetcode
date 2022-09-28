package com.sunstriker.leetcode;

public class L334递增的三元子序列 {
    public boolean increasingTripletUsingMonotonicStack(int[] nums) {
        // 模拟栈
        Integer bottom = null, top = null, tempTop = null;
        for (int num : nums) {
            if(tempTop!= null && num > tempTop) return true;
            if(top == null){
                if(bottom == null){
                    bottom = num;
                }else{
                    if (num > bottom) top = num;
                    else bottom = num;
                }
            }else {
                if(num > top) return true;
                else {
                    if(num > bottom) top = num;
                    else{
                        tempTop = top;
                        top = null;
                        bottom = num;
                    }
                }
            }
        }
        return false;
    }

    public boolean increasingTripletGreedy(int[] nums) {
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if(num > second) return true;
            else if (num > first) second = num;
            else first = num;
        }
        return false;
    }
}
