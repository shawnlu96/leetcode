package com.sunstriker.jzoffer;

import java.util.*;

public class JZ57和为S的两个数字 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int l = 0, r = array.length - 1;
        while (l < r) {
            if (array[l] + array[r] > sum) {
                r--;
            } else if (array[l] + array[r] < sum) {
                l++;
            } else {
               ArrayList<Integer> res = new ArrayList<>();
               res.add(array[l] );
               res.add(array[r] );
            }
        }
        return new ArrayList<>();
    }
}
