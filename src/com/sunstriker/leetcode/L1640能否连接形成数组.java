package com.sunstriker.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class L1640能否连接形成数组 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0],i);
        }
        int index = 0;
        while (index < arr.length){
            int currNum = arr[index];
            if(!map.containsKey(currNum)) return false;
            int[] piece = pieces[map.get(currNum)];
            for (int num : piece) {
                if(num != arr[index++]) return false;
            }
        }
        return true;
    }
}
