package com.sunstriker.jzoffer;

import java.util.ArrayList;

public class JZ74和为S的连续正数序列 {
    public static void main(String[] args) {
        var res = new JZ74和为S的连续正数序列().FindContinuousSequence(9);
    }
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if(sum <= 2) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int i=1,j=1, currSum = 1;
        while (j<=sum){
            if(currSum < sum){
                currSum+=++j;
            } else if (currSum > sum) {
                currSum -= i++;
            }else{
                if(i<j) {
                    res.add(generate(i, j));
                    currSum += ++j;
                }else{
                    break;
                }
            }
        }
        return res;
    }

    private ArrayList<Integer> generate(int i, int j) {
        int k = i;
        ArrayList<Integer> res = new ArrayList<>();
        while (k<=j){
            res.add(k++);
        }
        return res;
    }
}
