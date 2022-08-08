package com.sunstriker.jzoffer;

import java.util.HashMap;

public class JZ39数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : array) {
            if(map.containsKey(i)) map.put(i, map.get(i)+1);
            else map.put(i,1);
        }
        for (Integer i : map.keySet()) {
            if(map.get(i) >  array.length/2)  return i;
        }
        return 0;
    }
}
