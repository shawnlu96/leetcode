package com.sunstriker.jzoffer;
import java.util.*;
import java.util.function.IntFunction;


public class JZ42连续子数组的最大和 {
    public static void main(String[] args) {
        var res = FindGreatestSumOfSubArray2(new int[] {1,-2,3,10,-4,7,2,-5});
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        int before = array[0], curr=0;
        int max = before;
        for (int i = 1; i < array.length; i++) {
            if(before < 0){
                curr = array[i];
            }else {
                curr = array[i] + before;
            }
            if(curr > max) max = curr;
            before = curr;
        }
        return max;
    }

    public static int[] FindGreatestSumOfSubArray2 (int[] array) {
        // write code here
        if(array.length==1) return array;
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(array[0]);
        int before = array[0], curr=0;
        int max = before;
        for (int i = 1; i < array.length; i++) {
            if(before < 0){
                temp.clear();
                curr = array[i];
            }else {
                curr = array[i] + before;
            }
            temp.add(array[i]);
            if(curr > max) {
                res = new ArrayList<>(temp);
                max = curr;
            }
            if(curr == max) {
                if(temp.size()>=res.size()){
                    res = new ArrayList<>(temp);
                }
            }
            before = curr;
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
